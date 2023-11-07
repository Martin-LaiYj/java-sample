package com.martin.mysample.pattern.creational.factory.factory;

import com.martin.mysample.pattern.creational.factory.product.AbstractProductA;
import com.martin.mysample.pattern.creational.factory.product.AbstractProductB;
import com.martin.mysample.pattern.creational.factory.product.ProductB1;
import com.martin.mysample.pattern.creational.factory.product.ProductA1;

/**
 * AbstractFactory
 *
 * @author Martin
 * @since 2023-11-01 22:03
 **/

public class ConcreteAbstractFactoryA extends AbstractFactory {

    @Override
    public AbstractProductA createProductA() {
        return new ProductA1();
    }
    @Override
    public AbstractProductB createProductB() {
        return new ProductB1();
    }

}
