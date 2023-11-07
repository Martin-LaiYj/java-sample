package com.martin.mysample.pattern.creational.factory.factory;

import com.martin.mysample.pattern.creational.factory.product.AbstractProductA;
import com.martin.mysample.pattern.creational.factory.product.AbstractProductB;


/**
 * AbstractFactory
 *
 * @author Martin
 * @since 2023-11-01 22:03
 **/

public abstract class AbstractFactory {

     public abstract AbstractProductA createProductA();

     public abstract AbstractProductB createProductB();

}
