//package com.itdotaer.basiclearn.threadsafe.chapter5;
//
//import java.util.concurrent.BrokenBarrierException;
//import java.util.concurrent.CyclicBarrier;
//
///**
// * CellularAutomata
// *
// * @author jt_hu
// * @date 2018/11/26
// */
//public class CellularAutomata {
//
//    private final Board mainBoard;
//    private final CyclicBarrier barrier;
//    private final Worker[] workers;
//
//    public CellularAutomata(Board board) {
//        this.mainBoard = board;
//        int count = Runtime.getRuntime().availableProcessors();
//
//        this.barrier = new CyclicBarrier(count,
//                () -> mainBoard.commitNewValues());
//        this.workers = new Worker[count];
//        for (int i = 0; i< count; i++) {
//            workers[i] = new Worker(mainBoard.getSubBoard(count, i));
//        }
//    }
//
//    public void start() {
//        for (int i = 0; i < workers.length; i++) {
//            new Thread(workers[i]).start();
//        }
//
//        mainBoard.waitForConvergence();
//    }
//
//
//    private class Worker implements Runnable {
//
//        private final Board board;
//
//        public Worker(Board board) {
//            this.board = board;
//        }
//
//        /**
//         * When an object implementing interface <code>Runnable</code> is used
//         * to create a thread, starting the thread causes the object's
//         * <code>run</code> method to be called in that separately executing
//         * thread.
//         * <p>
//         * The general contract of the method <code>run</code> is that it may
//         * take any action whatsoever.
//         *
//         * @see Thread#run()
//         */
//        @Override
//        public void run() {
//            while (!board.hasConverged()) {
//                for ( int x = 0; x < board.getMaxX(); x++) {
//                    for (int y = 0; y < board.getMaxY(); y++) {
//                        board.setNewValue(x, y, computeValue(x, y));
//                    }
//                }
//
//                try {
//                    barrier.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (BrokenBarrierException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//}
