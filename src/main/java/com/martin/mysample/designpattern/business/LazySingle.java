package com.martin.mysample.designpattern.business;


public class LazySingle {

    private static LazySingle INSTANCE;

    private LazySingle() {
    }

    // 普通方式
    public static LazySingle getInstance(){
        if (INSTANCE==null){
            INSTANCE = new LazySingle();
        }
        return INSTANCE;
    }

    // 方式一：同步方法
    public static synchronized LazySingle getInstance1() {
        if (INSTANCE == null) {
            INSTANCE = new LazySingle();
        }
        return INSTANCE;
    }

    // 方式二：同步代码块
    public static LazySingle getInstance2() {
        synchronized (LazySingle.class) {
            if (INSTANCE == null) {
                INSTANCE = new LazySingle();
            }
            return INSTANCE;
        }
    }

    // 方式三：双重检查锁
    public static LazySingle getInstance3() {
        if (INSTANCE == null) {
            synchronized (LazySingle.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LazySingle();
                }
            }
        }
        return INSTANCE;
    }
}