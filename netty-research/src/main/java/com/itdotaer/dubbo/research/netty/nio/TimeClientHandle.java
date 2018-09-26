package com.itdotaer.dubbo.research.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * TimeClientHandle
 *
 * @author jt_hu
 * @date 2018/9/26
 */
public class TimeClientHandle implements Runnable {

    private String host;
    private int port;
    private Selector selector;
    private SocketChannel socketChannel;
    private volatile boolean stop;

    public TimeClientHandle(String host, int port) {
        this.host = host;
        this.port = port;

        try {
            selector = Selector.open();
            socketChannel = SocketChannel.open();

            socketChannel.configureBlocking(false);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
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
        try {
            doConnect();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        while (!stop) {
            try {
                selector.select(1000);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();

                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                SelectionKey selectionKey = null;

                while (iterator.hasNext()) {
                    selectionKey = iterator.next();
                    iterator.remove();

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
            SocketChannel channel = (SocketChannel) key.channel();

            if (key.isConnectable()) {
                if (channel.finishConnect()) {
                    channel.register(selector, SelectionKey.OP_READ);
                    doWrite(channel);
                } else {
                    System.exit(1);
                }
            }

            if (key.isReadable()) {
                ByteBuffer reader = ByteBuffer.allocate(1024);

                int readBytes = channel.read(reader);

                if (readBytes > 0) {
                    reader.flip();
                    byte[] bytes = new byte[reader.remaining()];
                    reader.get(bytes);

                    String body = new String(bytes, "UTF-8");
                    System.out.println("Now is :" + body);

                    this.stop = true;
                } else if (readBytes < 0) {
                    key.cancel();
                    channel.close();
                } else {
                    // ignore
                }
            }
        }
    }

    private void doConnect() throws IOException {
        if (socketChannel.connect(new InetSocketAddress(host, port))) {
            socketChannel.register(selector, SelectionKey.OP_READ);
            doWrite(socketChannel);
        } else {
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
        }
    }

    private void doWrite(SocketChannel socketChannel) throws IOException {
        byte[] req = "QUERY TIME ORDER".getBytes();
        ByteBuffer writeBuffer = ByteBuffer.allocate(req.length);
        writeBuffer.put(req);
        writeBuffer.flip();
        socketChannel.write(writeBuffer);

        if (!writeBuffer.hasRemaining()) {
            System.out.println("Send order to server succeed");
        }
    }
}
