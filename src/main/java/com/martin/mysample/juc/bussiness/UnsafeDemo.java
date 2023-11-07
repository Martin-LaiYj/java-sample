package com.martin.mysample.juc.bussiness;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * UnsafeDemo
 *
 * @author Martin
 * @since 2023-11-06 16:58
 **/

@Slf4j
@Getter
public class UnsafeDemo implements Runnable {
    private boolean flag;

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        flag = true;
        System.out.println(Thread.currentThread().getName() + " change the flag to:" + flag);
    }
}
