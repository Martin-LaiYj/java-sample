package com.martin.mysample.thread;

import org.junit.jupiter.api.Test;

class EvenNumberTest {

    @Test
    public void testPrintEvenNumber() {
        EvenNumber t1 = new EvenNumber();
        t1.start();

        EvenNumber t2 = new EvenNumber();
        t2.start();

        // 主线程执行for循环
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " i = " + i);
            }
        }
    }

    @Test
    public void testAnonymous() {
        new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + " i = " + i);
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + " i = " + i);
                    }
                }
            }
        }.start();
    }

    @Test
    public void testJoin() {
        EvenNumberRunnable p = new EvenNumberRunnable();

        Thread t1 = new Thread(p);
        t1.start();

        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " i = " + i);
            }

            if (i % 20 == 0) {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        System.out.println(t1.isAlive());
    }

}

