package com.martin.mysample.thread;

/**
 * Window
 *
 * @author Martin
 * @since 2023-10-18 10:06
 **/

public class WindowBlock implements Runnable {

    private Integer ticket = 100;

    static boolean soldOut = false;

    @Override
    public void run() {

        while (!soldOut) {

            saleTicket();
        }
    }

    private synchronized void saleTicket() {

        if (ticket > 0) {
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }

            System.out.println(Thread.currentThread().getName() + "售票，票号：" + ticket--);

        } else {
            soldOut = true;
        }
    }
}
