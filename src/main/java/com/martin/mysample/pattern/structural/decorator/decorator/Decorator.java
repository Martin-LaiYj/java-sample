package com.martin.mysample.pattern.structural.decorator.decorator;


import com.martin.mysample.pattern.structural.decorator.component.Component;

/**
 * Decorator
 *
 * @author Martin
 * @since 2023-11-03 20:10
 **/

public abstract class Decorator implements Component {

    protected Component component;

    protected String name;

    public Decorator(Component component, String name) {
        this.component = component;
        this.name = name;
    }
}
