package com.martin.mysample.design_pattern.structural_pattern.decorator.decorator;

import com.martin.mysample.design_pattern.structural_pattern.decorator.component.Component;

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