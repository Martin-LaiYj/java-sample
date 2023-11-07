package com.martin.mysample.pattern.creational.singleton;

/**
 * 线程安全的饿汉式单例类
 *
 * @author Martin
 * @since 2023-11-02 17:18
 **/

public class HungrySingle {

    private static final HungrySingle INSTANCE = new HungrySingle();

    private HungrySingle() {
    }

    public static HungrySingle getInstance() {
        return INSTANCE;
    }
}