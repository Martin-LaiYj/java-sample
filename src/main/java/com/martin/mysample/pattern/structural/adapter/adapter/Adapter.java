package com.martin.mysample.pattern.structural.adapter.adapter;


import com.martin.mysample.pattern.structural.adapter.target.Target;

/**
 * Adapter
 *
 * @author Martin
 * @since 2023-11-02 22:33
 **/

public class Adapter implements Target {

    Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}
