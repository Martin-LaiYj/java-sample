package com.martin.mysample.juc.bussiness;

import com.martin.mysample.utils.UnsafeUtils;
import lombok.extern.slf4j.Slf4j;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * CASDemo
 *
 * @author Martin
 * @since 2023-11-06 16:04
 **/

@Slf4j
public class CASDemo {

    private volatile int a = 0;

    Unsafe unsafe = UnsafeUtils.reflectGetUnsafe();

    public void increase(int x) {
        while (true) {
            try {
                long fieldOffset = unsafe.objectFieldOffset(CASDemo.class.getDeclaredField("a"));
                boolean result = unsafe.compareAndSwapInt(this, fieldOffset, x - 1, x);
                System.out.println("a = " + a);
                if (result) {
                    break;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}
