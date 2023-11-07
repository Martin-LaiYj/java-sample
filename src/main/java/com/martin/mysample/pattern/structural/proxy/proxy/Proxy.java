package com.martin.mysample.pattern.structural.proxy.proxy;

import com.martin.mysample.pattern.structural.proxy.subject.Subject;
import com.martin.mysample.pattern.structural.proxy.subject.RealSubject;

/**
 * Proxy
 *
 * @author Martin
 * @since 2023-11-03 08:08
 **/

public class Proxy implements Subject {

    RealSubject realSubject;
    String msg;

    public Proxy(String msg){
        this.msg = msg;
    }

    @Override
    public void request() {
        if(realSubject==null){
            realSubject = new RealSubject(msg);
        }
        realSubject.request();
    }
}
