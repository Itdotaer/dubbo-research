package com.itdotaer.sync;

/**
 * CustomSync
 *
 * @author jt_hu
 * @date 2019-01-22
 */
public class CustomSync {

    private Object object = new Object();

    public static synchronized void func() {
        System.out.println("func");
    }

    public void func1() {
        synchronized (object) {
            System.out.println("func1");
        }
    }

    public synchronized void func2() {
        System.out.println("func2");
    }

}
