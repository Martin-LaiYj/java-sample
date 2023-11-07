package com.martin.mysample.demo.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * User
 *
 * @author Martin
 * @since 2023-10-24 20:29
 **/

@Component
@ConfigurationProperties(prefix = "user")
@Data
public class User  {

    private String name;

    private Integer age;

    private String email;
}
