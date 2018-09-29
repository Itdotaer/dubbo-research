package com.itdotaer.dubbo.research.netty.protobuf;

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
        SubReqProto.SubReq subReq = (SubReqProto.SubReq) msg;

        System.out.println("Receive client request: " + msg);

        SubRespProto.SubResp subResp = generateResp(subReq);

        ctx.writeAndFlush(subResp);
    }

    private SubRespProto.SubResp generateResp(SubReqProto.SubReq subReq) {
        SubRespProto.SubResp.Builder builder = SubRespProto.SubResp.newBuilder();

        builder.setOrderId(subReq.getOrderId());
        builder.setPrice(subReq.getPrice());
        builder.setProductName(subReq.getProductName());
        builder.setDesc("Order create succeed");

        return builder.build();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
