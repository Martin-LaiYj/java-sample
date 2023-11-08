package com.martin.mysample.demo.model;

import lombok.Data;

/**
 * Animal
 *
 * @author Martin
 * @since 2023-10-12 09:34
 **/

@Data
public class Animal {

    void bark(){
        System.out.println("animal bark!");
    }
}
