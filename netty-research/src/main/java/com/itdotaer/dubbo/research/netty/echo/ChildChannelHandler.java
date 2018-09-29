package com.itdotaer.dubbo.research.netty.echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * ChildChannelHandler
 *
 * @author jt_hu
 * @date 2018/9/28
 */
public class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
//        ByteBuf delimiter = Unpooled.copiedBuffer("$_".getBytes());

//        socketChannel.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, delimiter));
        socketChannel.pipeline().addLast(new FixedLengthFrameDecoder(20));
        socketChannel.pipeline().addLast(new StringDecoder());
        socketChannel.pipeline().addLast(new EchoServerHandler());
    }

}
