package com.itdotaer.dubbo.research.netty.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * TimeClientHandler
 *
 * @author jt_hu
 * @date 2018/9/28
 */
public class TimeClientHandler extends ChannelHandlerAdapter {

    private final ByteBuf buf;

    public TimeClientHandler() {
        byte[] req = "QUERY TIME ORDER".getBytes();

        buf = Unpooled.buffer(req.length);
        buf.writeBytes(req);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(buf);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] bytes = new byte[buf.readableBytes()];

        buf.readBytes(bytes);
        String resp = new String(bytes);

        System.out.println("Now is :" + resp);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.err.println("Exception : " + cause);
        ctx.close();
    }

}
