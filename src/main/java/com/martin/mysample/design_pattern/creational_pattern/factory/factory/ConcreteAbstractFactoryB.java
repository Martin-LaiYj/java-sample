package com.martin.mysample.design_pattern.creational_pattern.factory.factory;

import com.martin.mysample.design_pattern.creational_pattern.factory.product.AbstractProductA;
import com.martin.mysample.design_pattern.creational_pattern.factory.product.AbstractProductB;
import com.martin.mysample.design_pattern.creational_pattern.factory.product.ProductA2;
import com.martin.mysample.design_pattern.creational_pattern.factory.product.ProductB2;

/**
 * AbstractFactory
 *
 * @author Martin
 * @since 2023-11-01 22:03
 **/

public class ConcreteAbstractFactoryB extends AbstractFactory {

    @Override
    public AbstractProductA createProductA() {
        return new ProductA2();
    }
    @Override
    public AbstractProductB createProductB() {
        return new ProductB2();
    }

}
