package com.martin.mysample.design_pattern.structural_pattern.decorator.component;


/**
 * ConcreteComponent
 *
 * @author Martin
 * @since 2023-11-03 20:10
 **/

public class ConcreteComponent implements Component {
    @Override
    public void operate() {
        System.out.println(this.getClass().getName() + "执行ConcreteComponent的operation方法");
    }
}
