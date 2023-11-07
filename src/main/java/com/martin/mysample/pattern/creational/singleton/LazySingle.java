package com.martin.mysample.pattern.creational.singleton;

/**
 * 懒汉式单例类
 *
 * @author Martin
 * @since 2023-11-02 17:18
 **/

public class LazySingle {

    private static LazySingle INSTANCE;

    private LazySingle() {
    }

    // 普通方式，线程不安全
    public static LazySingle getInstance(){
        if (INSTANCE==null){
            INSTANCE = new LazySingle();
        }
        return INSTANCE;
    }

    // 方式一：同步方法，线程安全，但会造成阻塞
    public static synchronized LazySingle getInstance1() {
        if (INSTANCE == null) {
            INSTANCE = new LazySingle();
        }
        return INSTANCE;
    }

    // 方式二：同步代码块，线程安全，也会造成阻塞
    public static LazySingle getInstance2() {
        synchronized (LazySingle.class) {
            if (INSTANCE == null) {
                INSTANCE = new LazySingle();
            }
            return INSTANCE;
        }
    }

    // 方式三：双重检查锁，线程安全且效率较高
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