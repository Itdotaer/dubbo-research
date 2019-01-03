package com.itdotaer.basiclearn.threadsafe.chapter5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Preloader
 *
 * @author jt_hu
 * @date 2018/11/22
 */
public class Preloader {

    private final FutureTask<ProductInfo> future = new FutureTask<ProductInfo>(
            () -> loadProductInfo()
    );

    private final Thread thread = new Thread(future);

    public void start() {
        this.thread.start();
    }

    public ProductInfo get() {
        try {
            return future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    private ProductInfo loadProductInfo() {
        return new ProductInfo();
    }

}
