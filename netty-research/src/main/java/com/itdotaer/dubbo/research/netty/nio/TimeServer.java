package com.itdotaer.dubbo.research.netty.nio;

/**
 * EchoServer
 *
 * @author jt_hu
 * @date 2018/9/25
 */
public class TimeServer {

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

        new Thread(new MultiplexerTimeServer(port), "EchoServer-001").start();
    }

}
