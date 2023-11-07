package com.martin.mysample.designpattern.business;

/**
 * Singleton
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
