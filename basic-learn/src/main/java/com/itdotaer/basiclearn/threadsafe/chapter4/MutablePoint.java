package com.itdotaer.basiclearn.threadsafe.chapter4;

/**
 * MutablePoint
 *
 * @author jt_hu
 * @date 2018/11/22
 */
public class MutablePoint {

    public int x, y;

    public MutablePoint() {
        x = 0;
        y = 0;
    }

    public MutablePoint(MutablePoint p) {
        this.x = p.x;
        this.y = p.y;
    }

}
