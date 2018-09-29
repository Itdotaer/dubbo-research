package com.itdotaer.dubbo.research.netty.nio;

/**
 * SubReqClient
 *
 * @author jt_hu
 * @date 2018/9/25
 */
public class TimeClient {

    private static final String DEFAULT_IP_ADDRESS = "127.0.0.1";
    private static final int DEFAULT_PORT = 8080;

    public static void main(String[] args) {
        int port = DEFAULT_PORT;

        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                // Default
            }
        }

        new Thread(new TimeClientHandle(DEFAULT_IP_ADDRESS, port), "SubReqClient-001").start();
    }

}
