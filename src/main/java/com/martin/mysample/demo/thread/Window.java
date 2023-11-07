package com.martin.mysample.demo.thread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Window
 *
 * @author Martin
 * @since 2023-10-18 10:06
 **/

public class Window implements Runnable {

    private Integer ticket = 300;

    static Map<Integer, String> soldTicketMap = new ConcurrentHashMap<>();

    @Override
    public void run() {

//        try {
//            Thread.sleep(5);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        while (true) {
            // synchronized方法块应该把修改的参数（this中的所有成员变量）包含在内，否则就无法开启多线程
            // 因为synchronized方法块是对this中的所有参数进行上锁的
            synchronized (this) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "售票，票号：" + ticket--);

                } else break;
            }
        }


    }
}
