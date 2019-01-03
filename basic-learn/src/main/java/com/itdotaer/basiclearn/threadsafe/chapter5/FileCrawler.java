package com.itdotaer.basiclearn.threadsafe.chapter5;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * FileCrawler
 *
 * @author jt_hu
 * @date 2018/11/22
 */
public class FileCrawler implements Runnable {

    private final BlockingQueue<File> fileQueue = new LinkedBlockingDeque<>();
    private final FileFilter fileFilter = new FileFilter() {
        @Override
        public boolean accept(File pathname) {
            return false;
        }
    };
    private final File root = new File("path");

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

    }

    private void craw1(File root) {
        File[] entries = root.listFiles(fileFilter);

        if (entries != null) {
            for (File entry : entries) {
                if (entry.isDirectory()) {
                    craw1(entry);
                } else {
                    fileQueue.add(entry);
                }
            }
        }
    }

    public class Indexer implements Runnable {
        private final BlockingQueue<File> queue;

        public Indexer(BlockingQueue<File> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                //todo:
            }
        }

    }

}
