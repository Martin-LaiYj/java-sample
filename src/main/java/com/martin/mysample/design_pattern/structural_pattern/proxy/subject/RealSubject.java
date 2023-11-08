package com.martin.mysample.design_pattern.structural_pattern.proxy.subject;

/**
 * RealSubject
 *
 * @author Martin
 * @since 2023-11-03 08:08
 **/

public class RealSubject implements Subject {

    String msg;

    public RealSubject(String msg) {
        this.msg = msg;
    }

    @Override
    public void request() {
        System.out.println(this.getClass().getName() + "调用RealSubject类的request方法，msg：" + msg);
    }
}
