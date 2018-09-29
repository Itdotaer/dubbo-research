package com.itdotaer.dubbo.research.netty.echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.Date;

/**
 * SubReqServerHandler
 *
 * @author jt_hu
 * @date 2018/9/28
 */
public class EchoServerHandler extends ChannelHandlerAdapter {

    private int counter = 0;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String body = (String) msg;
        System.out.println("The echo server receive message(count=" + ++counter + "):" + body + ";length:" + body.length());

//        body += "$_";
//        ByteBuf resp = Unpooled.copiedBuffer(body.getBytes());
//        ctx.writeAndFlush(resp);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
