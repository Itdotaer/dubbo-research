package com.itdotaer.basiclearn.collections;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * AtomicReferenceTest
 *
 * @author jt_hu
 * @date 2018/11/21
 */
public class AtomicReferenceTest {

    public static void main(String[] args) {
        LinkedList<UserInfo> safeList = safeList();
        LinkedList<UserInfo> unsafeList = unsafeList();
    }

    public static LinkedList<UserInfo> safeList() {
        AtomicInteger id = new AtomicInteger(0);
        AtomicReference<LinkedList<UserInfo>> safeList = new AtomicReference<>(new LinkedList<>());

        Thread thread1 = new Thread(() -> {
            while (id.get() < 100) {
                final LinkedList<UserInfo> finalList = safeList.get();
                LinkedList<UserInfo> list = safeList.get();

                UserInfo userInfo = new UserInfo();
                userInfo.setId(id.incrementAndGet());

                list.add(userInfo);

                safeList.compareAndSet(finalList, list);
            }
        });

        Thread thread2 = new Thread(() -> {
            while (id.get() < 100) {
                final LinkedList<UserInfo> finalList = safeList.get();
                LinkedList<UserInfo> list = safeList.get();

                UserInfo userInfo = new UserInfo();
                userInfo.setId(id.incrementAndGet());

                list.add(userInfo);

                safeList.compareAndSet(finalList, list);
            }
        });

        thread1.start();
        thread2.start();

        return safeList.get();
    }

    public static LinkedList<UserInfo> unsafeList() {
        AtomicInteger id = new AtomicInteger(0);
        LinkedList<UserInfo> list = new LinkedList<>();

        Thread thread1 = new Thread(() -> {
            while (id.get() < 100) {
                UserInfo userInfo = new UserInfo();
                userInfo.setId(id.incrementAndGet());

                list.add(userInfo);
            }
        });


        Thread thread2 = new Thread(() -> {
            while (id.get() < 100) {
                UserInfo userInfo = new UserInfo();
                userInfo.setId(id.incrementAndGet());

                list.add(userInfo);
            }
        });

        thread1.start();
        thread2.start();

        return list;
    }

}
