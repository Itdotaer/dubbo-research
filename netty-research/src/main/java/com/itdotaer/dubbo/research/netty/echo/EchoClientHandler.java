package com.itdotaer.dubbo.research.netty.echo;

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
public class EchoClientHandler extends ChannelHandlerAdapter {

    private int counter = 0;
    private byte[] req;

    public EchoClientHandler() {
        this.req = ("Test message from HarryHu.$_").getBytes();
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
        String resp = (String) msg;

        System.out.println("The echo client receive message(count=" + ++counter + "):" + resp);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.err.println("Exception : " + cause);
        ctx.close();
    }

}
