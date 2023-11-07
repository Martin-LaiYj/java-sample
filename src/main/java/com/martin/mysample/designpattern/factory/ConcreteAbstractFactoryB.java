package com.martin.mysample.designpattern.factory;

import com.martin.mysample.designpattern.business.AbstractProductA;
import com.martin.mysample.designpattern.business.AbstractProductB;
import com.martin.mysample.designpattern.business.ProductA2;
import com.martin.mysample.designpattern.business.ProductB2;

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
