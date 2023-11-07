package com.martin.mysample.demo.thread;

/**
 * PrintNumber
 *
 * @author Martin
 * @since 2023-10-19 09:52
 **/

public class PrintNumber implements Runnable {

    private int i = 1;

    @Override
    public void run() {

        while (true) {
            synchronized (this) {

                // 唤醒wait中的线程并使其进入等待队列
                this.notify();

                if (i <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + i++);

                    try {
                        // 当前线程wait并放弃监视锁
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    break;
                }
            }
        }
    }
}
