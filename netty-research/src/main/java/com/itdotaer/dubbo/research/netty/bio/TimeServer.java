package com.itdotaer.dubbo.research.netty.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);

            System.out.println("The time server is started on port :" + port);

            Socket socket = null;

            while(true) {
                socket = serverSocket.accept();

                new Thread(new TimeServerHandler(socket)).start();
            }
        } catch (IOException e) {
            System.err.println("The time server has crashed with exception ");
            System.err.println(e);
        } finally {
            if (serverSocket != null) {
                System.out.println("The time server will be closed");
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    System.err.println("The time server wasn't rightly closed ");
                    System.err.println(e);
                }
                System.out.println("The time server was closed");

                serverSocket = null;
            }
        }
    }

}
