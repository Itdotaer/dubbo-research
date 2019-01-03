package com.itdotaer.basiclearn.collections;

/**
 * Holder
 *
 * @author jt_hu
 * @date 2018/11/21
 */
public class Holder {

    private int n;

    public Holder(int n) {
        this.n = n;
    }

    public void assertSanity() {
        if (n != n) {
            System.err.println("Not ready");
        }
    }

}
