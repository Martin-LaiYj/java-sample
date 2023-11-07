package com.martin.mysample.thread;

import com.martin.mysample.demo.thread.HungrySingle;
import com.martin.mysample.demo.thread.LazySingle;
import org.junit.jupiter.api.Test;

/**
 * SingletonTest
 *
 * @author Martin
 * @since 2023-10-18 17:29
 **/

public class SingletonTest {

    HungrySingle hs1;
    HungrySingle hs2;

    LazySingle ls1;
    LazySingle ls2;

    @Test
    public void testHungry() {

        // 声明一个Thread的匿名内部子类并重写run方法
        Thread t1 = new Thread() {
            @Override
            public void run() {
                hs1 = HungrySingle.getInstance();
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                hs2 = HungrySingle.getInstance();
            }
        };

        // 对t1和t2调用start方法开启线程
        t1.start();
        t2.start();


        // 此处必须等待t1和t2线程执行完后再执行后续的sout打印操作，才能保证hs1和hs2对象正确地获取到HungrySingle的单例对象
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(hs1);
        System.out.println(hs2);
        System.out.println(hs1 == hs2);
    }

    @Test
    public void testLazy(){
        // 声明一个Thread的匿名内部子类并重写run方法
        Thread t1 = new Thread() {
            @Override
            public void run() {
                ls1 = LazySingle.getInstance3();
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                ls2 = LazySingle.getInstance3();
            }
        };

        // 对t1和t2调用start方法开启线程
        t1.start();
        t2.start();


        // 此处必须等待t1和t2线程执行完后再执行后续的sout打印操作，才能保证hs1和hs2对象正确地获取到HungrySingle的单例对象
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(ls1);
        System.out.println(ls2);
        System.out.println(ls1 == ls2);
    }

    @Test
    public void testLazyInner(){
        Object lazyInner = LazySingle.getInnerInstance();
        System.out.println(lazyInner);
    }



}
