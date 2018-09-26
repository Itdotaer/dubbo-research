package com.itdotaer.dubbo.research.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * MultiplexerTimeServer
 *
 * @author jt_hu
 * @date 2018/9/26
 */
public class MultiplexerTimeServer implements Runnable {

    private Selector selector;
    private ServerSocketChannel srvChannel;
    private volatile boolean stop;

    public MultiplexerTimeServer(int port) {
        try {
            selector = Selector.open();
            srvChannel = ServerSocketChannel.open();

            srvChannel.configureBlocking(false);
            srvChannel.socket().bind(new InetSocketAddress(port), 1024);
            srvChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("The time server started on port : " + port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void stop() {
        this.stop = stop;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        while (!stop) {
            try {
                selector.select(1000);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();

                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                SelectionKey selectionKey = null;

                while (iterator.hasNext()) {
                    selectionKey = iterator.next();

                    try {
                        handleInput(selectionKey);
                    } catch (Exception e) {
                        if (selectionKey != null) {
                            selectionKey.cancel();

                            if (selectionKey.channel() != null) {
                                selectionKey.channel().close();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }

        if (selector != null) {
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey key) throws IOException {
        if (key.isValid()) {
            if (key.isAcceptable()) {
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                SocketChannel channel = ssc.accept();
                channel.configureBlocking(false);

                channel.register(selector, SelectionKey.OP_READ);
            }

            if (key.isReadable()) {
                SocketChannel channel = (SocketChannel) key.channel();
                ByteBuffer reader = ByteBuffer.allocate(1024);

                int readBytes = channel.read(reader);

                if (readBytes > 0) {
                    reader.flip();
                    byte[] bytes = new byte[reader.remaining()];
                    reader.get(bytes);

                    String body = new String(bytes, "UTF-8");
                    System.out.println("The time server receive order :" + body);

                    String currencTime = "QUERY TIME ORDER".equalsIgnoreCase(body)
                            ? (new Date(System.currentTimeMillis())).toString() : "BAD ORDER";

                    doWrite(channel, currencTime);
                } else if (readBytes < 0) {
                    key.cancel();
                    channel.close();
                } else {
                    // ignore
                }
            }
        }
    }

    private void doWrite(SocketChannel socketChannel, String response) throws IOException {
        if (response != null && response.trim().length() > 0) {
            byte[] bytes = response.getBytes();
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();

            socketChannel.write(writeBuffer);
        }
    }

}
