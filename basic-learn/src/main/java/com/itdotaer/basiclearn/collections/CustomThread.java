package com.itdotaer.basiclearn.collections;

/**
 * CustomThread
 *
 * @author jt_hu
 * @date 2018/10/19
 */
public class CustomThread extends Thread {

    ThreadInfo threadInfo;

    public CustomThread(ThreadInfo threadInfo, String name) {
        this.threadInfo = threadInfo;
        this.setName(name);
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        threadInfo.threadLocal.set(this.getName());
    }
}
