package com.martin.mysample.designpattern.factory;

import com.martin.mysample.designpattern.business.AbstractProductA;
import com.martin.mysample.designpattern.business.AbstractProductB;


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
