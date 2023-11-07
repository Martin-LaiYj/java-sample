package com.martin.mysample.redis;

import com.martin.mysample.demo.pojo.UserDTO;
import com.martin.mysample.utils.JsonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * StringRedisTemplateTest
 *
 * @author Martin
 * @since 2023-10-11 15:59
 **/

@SpringBootTest
public class StringRedisTemplateTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testUserString() throws IOException {
        final String TEST_USER2 = "redis:template:demo:user2";
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Martin");
        userDTO.setAge(24);
        String jsonStr = JsonUtils.toJSONString(userDTO);
        stringRedisTemplate.opsForValue().set(TEST_USER2, jsonStr, 15, TimeUnit.MINUTES);
        String userStr = stringRedisTemplate.opsForValue().get(TEST_USER2);
        UserDTO user = JsonUtils.parseObjectThrow(userStr, UserDTO.class);
        System.out.println("user = " + user);
    }

    @Test
    public void testStringHash() {
        final String TEST_HASH2 = "redis:template:demo:hash2";
        stringRedisTemplate.opsForHash().put(TEST_HASH2, "name", "XJ");
        stringRedisTemplate.opsForHash().put(TEST_HASH2, "age", "54");
        Map<Object, Object> hashMap = stringRedisTemplate.opsForHash().entries(TEST_HASH2);
        System.out.println("hashMap = " + hashMap);
    }


}
