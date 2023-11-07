package com.martin.mysample.demo.thread;

/**
 * HungrySingle
 *
 * @author Martin
 * @since 2023-10-18 17:27
 **/

public class HungrySingle {

    // 在类初始化时就创建单例对象
    private static HungrySingle INSTANCE = new HungrySingle();

    // 单例模式中必须声明一个私有构造器
    private HungrySingle(){}

    // 通过getInstance方法获取单例对象
    public static HungrySingle getInstance(){
        return INSTANCE;
    }
}
