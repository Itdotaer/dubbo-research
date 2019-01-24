package com.itdotaer.basiclearn.threadsafe;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * FutureTest
 *
 * @author jt_hu
 * @date 2019-01-03
 */
public class FutureTest {

    @Test
    public void futureTest() throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        Long start = System.nanoTime();
        Future<String> future1 = threadPool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                System.out.println("future 1 call");

                return "future 1";
            }
        });

        Future<String> future2 = threadPool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                System.out.println("future 2 call");

                return "future 2";
            }
        });

        Future<String> future3 = threadPool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                System.out.println("future 3 call");

                return "future 3";
            }
        });

        future1.get();
        future2.get();
        future3.get();

        Long end = System.nanoTime();

        System.out.println(String.format("used (%s) mill seconds", (end - start) / Math.pow(10, 6)));
    }

}
