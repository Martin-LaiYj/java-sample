package com.martin.mysample.demo.thread;

/**
 * EvenNumber
 *
 * @author Martin
 * @since 2023-10-17 16:23
 **/

public class EvenNumberRunnable implements Runnable {

    @Override
    public void run() {
        // 打印1-100内偶数
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " i = " + i);
            }
        }
    }
}
