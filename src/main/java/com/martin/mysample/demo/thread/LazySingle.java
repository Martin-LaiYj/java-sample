package com.martin.mysample.demo.thread;

/**
 * LazySingle
 *
 * @author Martin
 * @since 2023-10-18 17:59
 **/

public class LazySingle {

    private static LazySingle INSTANCE;

    private LazySingle() {
    }

    // 方式一
    public static synchronized LazySingle getInstance1() {
        if (INSTANCE == null) {
            INSTANCE = new LazySingle();
        }
        return INSTANCE;
    }

    // 方式二
    public static LazySingle getInstance2() {
        synchronized (LazySingle.class) {
            if (INSTANCE == null) {
                INSTANCE = new LazySingle();
            }
            return INSTANCE;
        }
    }

    // 方式三
    public static LazySingle getInstance3() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1000);//加这个代码，暴露问题
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (LazySingle.class) {

                if (INSTANCE == null) {
                    INSTANCE = new LazySingle();
                }
            }
        }
        return INSTANCE;
    }

    public static LazyInner getInnerInstance() {
        return LazyInner.getInstance();
    }

    // 定义一个私有内部类
    // 内部类只有被外部类调用时才会加载，对外属于懒汉式，对内属于饿汉式
    private static class LazyInner {

        // 内部类内部像饿汉式一样在加载时就声明LazyInner对象
        static final LazyInner INSTANCE = new LazyInner();

        public static LazyInner getInstance() {
            return INSTANCE;
        }

    }
}
