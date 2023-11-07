package com.martin.mysample.designpattern.factory;

import com.martin.mysample.designpattern.business.AbstractProductB;
import com.martin.mysample.designpattern.business.AbstractProductA;
import com.martin.mysample.designpattern.business.ProductA1;
import com.martin.mysample.designpattern.business.ProductB1;

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
