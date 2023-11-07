package com.martin.mysample.redis;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JedisTest
 *
 * @author Martin
 * @since 2023-10-10 16:54
 **/

public class JedisTest {

    private Jedis jedis;

//    public JedisTest() {
//        jedis = getConnect();
//    }

    @BeforeEach
    public void connect() {
        jedis = new Jedis("127.0.0.1", 6379);
        jedis.select(0);
        System.out.println("Connect!");
    }

    @Test
    public void testSetGet() {
//        Jedis jedis = getConnect();
        String result = jedis.set("name1", "Martin111");
        System.out.println("result = " + result);
        String name1 = jedis.get("name1");
        System.out.println("name1 = " + name1);
    }

    @AfterEach
    public void shutdown() {
        if (null != jedis) {
            jedis.close();
        }
        System.out.println("Close!");
    }

    @Test
    public void testHSet() {
        jedis.hset("hash:test:demo", "id", "111");
        jedis.hset("hash:test:demo", "name", "test");
    }

    @Test
    public void testHGet() {
        Map<String, String> stringStringMap = jedis.hgetAll("hash:test:demo");
        System.out.println("stringStringMap = " + stringStringMap);
    }

    @Test
    public void testHMSet() {
        Map<String, String> map = new HashMap<>();
        map.put("id", "222");
        map.put("name", "test2");
        map.put("desc", "this is test2 map for hmset test!");
        jedis.hmset("hash:test:demo2", map);
    }

    @Test
    public void testHMGet() {
        List<String> hmget = jedis.hmget("hash:test:demo2", "id", "name");
        System.out.println("hmget = " + hmget);
    }
}
