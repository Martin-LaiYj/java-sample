package com.martin.mysample.designpattern.business;

import com.martin.mysample.designpattern.api.ProxySubject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * DynamicProxy
 *
 * @author Martin
 * @since 2023-11-03 16:33
 **/

public class DynamicProxy implements InvocationHandler {

    private ProxySubject object;

    public DynamicProxy(ProxySubject object){
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
