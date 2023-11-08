package com.martin.mysample.design_pattern.creational_pattern.singleton;

/**
 * 线程安全的静态内部类
 *
 * @author Martin
 * @since 2023-11-02 17:18
 **/

public class Singleton {

    private Singleton() {
    }

    public static Singleton getInstance() {
        return InnerClass.INSTANCE;
    }

    public static class InnerClass {
        private static final Singleton INSTANCE = new Singleton();
    }

}
