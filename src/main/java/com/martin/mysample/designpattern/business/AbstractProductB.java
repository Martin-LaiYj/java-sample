package com.martin.mysample.designpattern.business;


import lombok.Data;

/**
 * ProductA1
 *
 * @author Martin
 * @since 2023-11-01 22:02
 **/

@Data
public abstract class AbstractProductB {

    public AbstractProductB() {
        System.out.println("创建产品B：" + this.getClass().getName());
    }
}
