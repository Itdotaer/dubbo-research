package com.itdotaer.dubbo.research.netty.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * SubReqClientHandler
 *
 * @author jt_hu
 * @date 2018/9/28
 */
public class TimeClientHandler extends ChannelHandlerAdapter {

    private int counter = 0;
    private byte[] req;

    public TimeClientHandler() {
        this.req = ("QUERY TIME ORDER" + System.getProperty("line.separator")).getBytes();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 100; i++) {
            ByteBuf buf = Unpooled.buffer(req.length);
            buf.writeBytes(req);

            ctx.writeAndFlush(buf);
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        ByteBuf buf = (ByteBuf) msg;
//        byte[] bytes = new byte[buf.readableBytes()];
//
//        buf.readBytes(bytes);
//        String resp = new String(bytes);
        String resp = (String) msg;

        System.out.println("Now is :" + resp + "; the counter is " + ++counter);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.err.println("Exception : " + cause);
        ctx.close();
    }

}
