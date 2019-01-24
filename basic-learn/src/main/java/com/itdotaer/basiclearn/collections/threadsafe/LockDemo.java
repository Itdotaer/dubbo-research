package com.itdotaer.basiclearn.collections.threadsafe;

/**
 * LockDemo
 *
 * @author jt_hu
 * @date 2019-01-24
 */
public class LockDemo {

    private static boolean a = false;
    private static boolean b = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (true) {
                if (!b) {
                    try {
                        System.out.println("Lock");
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Released");
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                if (!a) {
                    try {
                        System.out.println("Lock");
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Released");
                }
            }
        }).start();

        Thread.sleep(100);

        a = true;
        b = true;
    }

}
