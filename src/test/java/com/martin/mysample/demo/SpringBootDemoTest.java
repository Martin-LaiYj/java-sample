package com.martin.mysample.demo;


import com.martin.mysample.demo.bean.User;
import com.martin.mysample.utils.JsonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * SpringBootDemoTest
 *
 * @author Martin
 * @since 2023-10-24 20:31
 **/

@SpringBootTest()
public class SpringBootDemoTest {

    @Autowired
    User user;

    @Test
    public void testConfigurationProperties() {
        System.out.println("user = " + JsonUtils.toJSONString(user));
    }

}
