package com.itdotaer.basiclearn.collections;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * CustomAtomicInteger
 *
 * @author jt_hu
 * @date 2018/11/1
 */
public class CustomAtomicInteger {

    private static final Unsafe unsafe = CustomAtomicInteger.getUnsafe();
    private static long offset;

    static {
        try {
            offset = unsafe.objectFieldOffset(CustomAtomicInteger.class
                    .getDeclaredField("value"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private volatile int value;

    public CustomAtomicInteger() {
        value = 0;
    }

    public final int incrementAndGet() {
        return unsafe.getAndAddInt(this, offset, 1) + 1;
    }

    public final int decrementAndGet() {
        return unsafe.getAndAddInt(this, offset, -1) - 1;
    }

    @SuppressWarnings("restriction")
    private static Unsafe getUnsafe() {
        try {

            Field singleOneInstanceField = Unsafe.class.getDeclaredField("theUnsafe");
            singleOneInstanceField.setAccessible(true);
            return (Unsafe) singleOneInstanceField.get(null);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

}
