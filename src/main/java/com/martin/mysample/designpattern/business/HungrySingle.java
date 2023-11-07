package com.martin.mysample.designpattern.business;

public class HungrySingle {

    private static final HungrySingle INSTANCE = new HungrySingle();

    private HungrySingle() {
    }

    public static HungrySingle getInstance() {
        return INSTANCE;
    }
}