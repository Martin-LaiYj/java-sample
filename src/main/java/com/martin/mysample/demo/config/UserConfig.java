package com.martin.mysample.demo.config;

import com.martin.mysample.demo.pojo.UserDTO;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * UserConfig
 *
 * @author Martin
 * @since 2023-10-24 14:36
 **/

// 此处添加@Import注解
@Import({UserDTO.class, CacheProperties.Redis.class})
@Configuration
public class UserConfig {

    @Bean
    public UserDTO userConfig1() {
        return new UserDTO();
    }

    @Bean
    @ConditionalOnProperty(prefix = "user", name = "name111")
    public UserDTO userConfig3() {
        return new UserDTO();
    }
}
