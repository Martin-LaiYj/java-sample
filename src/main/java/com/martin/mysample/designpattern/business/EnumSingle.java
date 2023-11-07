package com.martin.mysample.designpattern.business;

public enum EnumSingle {

    INSTANCE,
    ;

    public EnumSingle getValue(){
        return INSTANCE;
    }
}
