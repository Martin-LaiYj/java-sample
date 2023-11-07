package com.martin.mysample.redis;

import com.martin.mysample.demo.factory.JedisConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

/**
 * JedisPoolTest
 *
 * @author Martin
 * @since 2023-10-10 18:04
 **/

public class JedisPoolTest {

    private Jedis jedis;

    @BeforeEach
    public void connect() {
        jedis = JedisConnectionFactory.getJedis();
    }

    @AfterEach
    public void shutdown() {
        if (null != jedis) {
            jedis.close();
        }
    }

    @Test
    public void testJedisPoolSetGet() {
        String result = jedis.set("pool:name", "martin222");
        System.out.println("result = " + result);
        String name = jedis.get("pool:name");
        System.out.println("name = " + name);
    }


}
