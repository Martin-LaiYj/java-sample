package com.martin.mysample.demo.factory;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

/**
 * JedisPoolFactory
 *
 * @author Martin
 * @since 2023-10-10 17:46
 **/

@Component
public class JedisConnectionFactory {

    private static final JedisPool jedisPool;

    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 最大连接
        jedisPoolConfig.setMaxTotal(8);
        // 最大空闲连接
        jedisPoolConfig.setMaxIdle(8);
        // 最小空闲连接
        jedisPoolConfig.setMinIdle(0);
        // 设置最长等待时间，单位s
        jedisPoolConfig.setMaxWait(Duration.ofSeconds(2));
        jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1",
                6379, 1000);
    }

    // 获取Jedis对象
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

}
