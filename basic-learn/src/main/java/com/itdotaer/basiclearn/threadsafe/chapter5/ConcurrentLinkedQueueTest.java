package com.itdotaer.basiclearn.threadsafe.chapter5;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * ConcurrentLinkedQueueTest
 *
 * @author jt_hu
 * @date 2018/11/22
 */
public class ConcurrentLinkedQueueTest {

    public static void main(String[] args) {
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();

        concurrentLinkedQueue.add(new Object());
        concurrentLinkedQueue.add(new Object());
        concurrentLinkedQueue.add(new Object());

        // 生产者-消费者应用
        concurrentLinkedQueue.poll();
        concurrentLinkedQueue.offer(new Object());

    }
}
