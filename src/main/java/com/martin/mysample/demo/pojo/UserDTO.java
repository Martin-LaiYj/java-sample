package com.martin.mysample.demo.pojo;

import lombok.Data;

/**
 * UserDTO
 *
 * @author Martin
 * @since 2023-10-11 15:06
 **/

@Data
public class UserDTO {

//    private static final long serialVersionUID = 5573858864281268151L;

    private String name;

    private Integer age;

    private DogDTO dog;

}
