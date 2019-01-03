package com.itdotaer.basiclearn.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * CustomThreadTest
 *
 * @author jt_hu
 * @date 2018/10/19
 */
public class CustomThreadTest {

    public static void main(String[] args) throws InterruptedException {
        List<CustomThread> threadList = new ArrayList<>();

        ThreadInfo threadInfo = new ThreadInfo();

        for (int i = 0; i < 10; i++) {
            CustomThread thread = new CustomThread(threadInfo, String.format("custom-thread-%d", i));

            thread.start();

            threadList.add(thread);
        }

        for (CustomThread customThread : threadList) {
            System.out.println(customThread.threadInfo.threadLocal.get());
        }

        System.out.println("End");
    }

}
