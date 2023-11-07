package com.martin.mysample.designpattern.business;

import com.martin.mysample.designpattern.api.Component;
import com.martin.mysample.designpattern.api.Decorator;

public class ConcreteDecoratorA extends Decorator {
    private Integer addedState = 0;

    public ConcreteDecoratorA(Component component, String name) {
        super(component, name);
    }

    @Override
    public void operate() {
        component.operate();
        addedState += 1;
        System.out.println("addedState = " + addedState);
    }
}