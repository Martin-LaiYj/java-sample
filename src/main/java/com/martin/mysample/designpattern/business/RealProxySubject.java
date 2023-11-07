package com.martin.mysample.designpattern.business;

import com.martin.mysample.designpattern.api.ProxySubject;

/**
 * RealSubject
 *
 * @author Martin
 * @since 2023-11-03 08:08
 **/

public class RealProxySubject implements ProxySubject {

    String msg;

    public RealProxySubject(String msg) {
        this.msg = msg;
    }

    @Override
    public void request() {
        System.out.println(this.getClass().getName() + "调用RealSubject类的request方法，msg：" + msg);
    }
}
