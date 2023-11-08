package com.martin.mysample.design_pattern.creational_pattern.factory.factory;

import com.martin.mysample.design_pattern.creational_pattern.factory.product.AbstractProductA;
import com.martin.mysample.design_pattern.creational_pattern.factory.product.AbstractProductB;
import com.martin.mysample.design_pattern.creational_pattern.factory.product.ProductB1;
import com.martin.mysample.design_pattern.creational_pattern.factory.product.ProductA1;

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
