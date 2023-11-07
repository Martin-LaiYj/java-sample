package com.martin.mysample.pattern.structural.decorator.decorator;

import com.martin.mysample.pattern.structural.decorator.component.Component;

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