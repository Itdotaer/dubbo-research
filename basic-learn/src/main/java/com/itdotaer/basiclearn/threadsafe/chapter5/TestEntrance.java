package com.itdotaer.basiclearn.threadsafe.chapter5;

import org.junit.Assert;
import org.junit.Test;

/**
 * TestEntrance
 *
 * @author jt_hu
 * @date 2018/11/26
 */
public class TestEntrance {

    @Test
    public void semaphoreTest() throws InterruptedException {
        // arrange
        int maxCount = 10;
        BoundedHashSet<String> hashSet = new BoundedHashSet<>(maxCount);

        // act
        for (int i = 0; i <= maxCount; i++) {
            hashSet.add("hash set : " + i);
        }

        // assert
        Assert.assertNotNull(hashSet);
    }

}
