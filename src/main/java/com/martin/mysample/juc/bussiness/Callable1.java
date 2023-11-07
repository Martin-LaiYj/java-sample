package com.martin.mysample.juc.bussiness;

import java.util.concurrent.Callable;

/**
 * @author martin
 */
public class Callable1 implements Callable {
    @Override
    public Object call() throws Exception {
        int evenSum = 0;// 记录偶数的和
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                evenSum += i;
            }
        }
        System.out.println("Callable测试接口所用线程：" + Thread.currentThread().getName());
        return evenSum;
    }
}