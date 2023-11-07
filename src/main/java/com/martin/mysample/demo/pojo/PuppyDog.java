package com.martin.mysample.demo.pojo;

/**
 * PuppyDog
 *
 * @author Martin
 * @since 2023-10-12 09:41
 **/

public class PuppyDog extends Dog {

    public void bark(){
        super.bark();
        System.out.println("PuppyDog bark!");
    }
}
