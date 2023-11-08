package com.martin.mysample.design_pattern.creational_pattern.singleton;

/**
 * 线程安全的枚举类
 *
 * @author Martin
 * @since 2023-11-02 17:18
 **/

public enum EnumSingle {

    INSTANCE,
    ;

    public EnumSingle getValue(){
        return INSTANCE;
    }
}
