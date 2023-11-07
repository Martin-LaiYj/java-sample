package com.martin.mysample.thread;

import org.junit.jupiter.api.Test;

class EvenNumberRunnableTest {

    @Test
    public void testPrint() {
        EvenNumberRunnable p = new EvenNumberRunnable();
        Thread t = new Thread(p);
        t.start();
    }

    @Test
    public void testAnonymous() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + " i = " + i);
                    }
                }
            }
        }) {
        }.start();
    }

}