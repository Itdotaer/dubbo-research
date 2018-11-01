package com.itdotaer.basiclean.collections;

/**
 * Automic
 *
 * @author jt_hu
 * @date 2018/10/30
 */
public class Atomic {

    public static void main(String[] args) {
        System.out.println("Thread safe num increment");

        CustomAtomicInteger num = new CustomAtomicInteger();

        new Thread(() -> {
            int count = 100;
            while(count-- > 0) {
                System.out.println("num(thread 1): " + num.incrementAndGet());
            }
        }).start();
        new Thread(() -> {
            int count = 100;
            while(count-- > 0) {
                System.out.println("num(thread 2): " + num.incrementAndGet());
            }
        }).start();
        new Thread(() -> {
            int count = 100;
            while(count-- > 0) {
                System.out.println("num(thread 3): " + num.incrementAndGet());
            }
        }).start();
    }

}
