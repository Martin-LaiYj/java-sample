package com.martin.mysample.redis;

import com.martin.mysample.demo.model.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Map;

/**
 * RedisTemplateTest
 *
 * @author Martin
 * @since 2023-10-11 10:34
 **/

@SpringBootTest
public class RedisTemplateTest {

    @Autowired
//    private RedisTemplate<String, String> redisTemplate;
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void testString() {
        final String TEST1 = "redis:template:demo:test4";
//        redisTemplate.setStringSerializer(new StringRedisSerializer());
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set(TEST1, "martin444");
        Object test1 = valueOperations.get(TEST1);
        System.out.println("test1 = " + test1);
    }

    @Test
    public void testUser() {
        final String TEST_USER = "redis:template:demo:user1";
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Martin");
        userDTO.setAge(24);
        redisTemplate.opsForValue().set(TEST_USER, userDTO);
        Object user = redisTemplate.opsForValue().get(TEST_USER);
        System.out.println("user = " + user);
    }

    @Test
    public void testHash(){
        final String TEST_HASH = "redis:template:demo:hash1";
        redisTemplate.opsForHash().put(TEST_HASH, "name","XJ");
        redisTemplate.opsForHash().put(TEST_HASH, "age","54");
        Map<Object, Object> hashMap = redisTemplate.opsForHash().entries(TEST_HASH);
        System.out.println("hashMap = " + hashMap);

    }

}
