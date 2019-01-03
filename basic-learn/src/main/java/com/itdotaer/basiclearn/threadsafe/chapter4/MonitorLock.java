package com.itdotaer.basiclearn.threadsafe.chapter4;

/**
 * MonitorLock
 *
 * @author jt_hu
 * @date 2018/11/22
 */
public class MonitorLock {

    public Object lockObj = new Object();

    public void someMetod() {
        synchronized (lockObj) {
            // do something
        }
    }

}
