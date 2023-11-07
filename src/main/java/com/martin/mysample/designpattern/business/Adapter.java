package com.martin.mysample.designpattern.business;

import com.martin.mysample.designpattern.api.Target;

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
