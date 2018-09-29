package com.itdotaer.dubbo.research.netty.udp;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;

import java.util.concurrent.ThreadLocalRandom;

/**
 * ChineseProverbServerHandler
 *
 * @author jt_hu
 * @date 2018/9/29
 */
public class ChineseProverbServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {

    private static final String[] DIC = {"只要功夫深铁杵磨成针", "关关雎鸠在河之洲", "锄禾日当午汗滴禾下土"};

    private String nextQuote() {
        int quoteId = ThreadLocalRandom.current().nextInt(DIC.length);

        return DIC[quoteId];
    }

    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket) throws Exception {
        String req = datagramPacket.content().toString(CharsetUtil.UTF_8);

        if ("查询?".equals(req)) {
            channelHandlerContext.writeAndFlush(new DatagramPacket(
                    Unpooled.copiedBuffer("查询结果:" + nextQuote(), CharsetUtil.UTF_8),
                    datagramPacket.sender()));
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        cause.printStackTrace();
    }
}
