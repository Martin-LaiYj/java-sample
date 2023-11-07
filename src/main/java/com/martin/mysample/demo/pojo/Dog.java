package com.martin.mysample.demo.pojo;

/**
 * Dog
 *
 * @author Martin
 * @since 2023-10-12 09:35
 **/

public class Dog extends Animal {

    @Override
    public void bark(){
//        super.bark();
        System.out.println("dog bark!");
    }
}
