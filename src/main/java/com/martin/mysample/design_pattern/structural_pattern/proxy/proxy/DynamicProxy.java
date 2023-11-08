package com.martin.mysample.design_pattern.structural_pattern.proxy.proxy;

import com.martin.mysample.design_pattern.structural_pattern.proxy.subject.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * DynamicProxy
 *
 * @author Martin
 * @since 2023-11-03 16:33
 **/

public class DynamicProxy implements InvocationHandler {

    private Subject object;

    public DynamicProxy(Subject object){
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行代理方法前...");
        Object result = method.invoke(object, args);
        System.out.println("执行代理方法后...");
        return result;
    }
}
