package com.martin.mysample.designpattern.business;

import com.martin.mysample.designpattern.api.Component;
import com.martin.mysample.designpattern.api.Decorator;

public class ConcreteDecoratorB extends Decorator {

    private Integer addedState = 0;

    public ConcreteDecoratorB(Component component, String name) {
        super(component, name);
    }

    @Override
    public void operate() {
        addedBehavior();
    }

    public void addedBehavior() {
        component.operate();
        addedState += 2;
        System.out.println("addedState = " + addedState);
    }
}