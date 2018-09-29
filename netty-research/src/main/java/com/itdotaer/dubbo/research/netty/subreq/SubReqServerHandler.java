package com.itdotaer.dubbo.research.netty.subreq;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * SubReqServerHandler
 *
 * @author jt_hu
 * @date 2018/9/28
 */
public class SubReqServerHandler extends ChannelHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        SubReq   subReq = (SubReq) msg;

        System.out.println("Receive client request: " + msg);

        SubResp subResp = generateResp(subReq);

        ctx.writeAndFlush(subResp);
    }

    private SubResp generateResp(SubReq subReq) {
        SubResp subResp = new SubResp();

        subResp.setOrderId(subReq.getOrderId());
        subResp.setPrice(subReq.getPrice());
        subResp.setProductName(subReq.getProductName());
        subResp.setDesc("Order create succeed");

        return subResp;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
