package com.martin.mysample.design_pattern.creational_pattern.factory.factory;

import com.martin.mysample.design_pattern.creational_pattern.factory.product.AbstractProductA;
import com.martin.mysample.design_pattern.creational_pattern.factory.product.AbstractProductB;


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
