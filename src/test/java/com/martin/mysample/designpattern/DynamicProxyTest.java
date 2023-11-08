package com.martin.mysample.designpattern;

import com.martin.mysample.design_pattern.structural_pattern.proxy.subject.Subject;
import com.martin.mysample.design_pattern.structural_pattern.proxy.proxy.DynamicProxy;
import com.martin.mysample.design_pattern.structural_pattern.proxy.subject.RealSubject;
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
        Subject object = new RealSubject("动态代理");
        Subject proxy = (Subject) Proxy.newProxyInstance(DesignPatternTest.class.getClassLoader(),
                object.getClass().getInterfaces(), new DynamicProxy(object));
        proxy.request();
    }
}
