package com.martin.mysample.designpattern;

import com.martin.mysample.designpattern.api.ProxySubject;
import com.martin.mysample.designpattern.business.DynamicProxy;
import com.martin.mysample.designpattern.business.RealProxySubject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Proxy;

/**
 * DynamicProxyTest
 *
 * @author Martin
 * @since 2023-11-03 16:41
 **/


@SpringBootTest
public class DynamicProxyTest {

    @Test
    public void testDynamicProxy() {
        ProxySubject object = new RealProxySubject("动态代理");
        ProxySubject proxy = (ProxySubject) Proxy.newProxyInstance(DesignPatternTest.class.getClassLoader(),
                object.getClass().getInterfaces(), new DynamicProxy(object));
        proxy.request();
    }
}
