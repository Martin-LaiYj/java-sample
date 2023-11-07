package com.martin.mysample.designpattern.business;

import com.martin.mysample.designpattern.api.ProxySubject;

/**
 * Proxy
 *
 * @author Martin
 * @since 2023-11-03 08:08
 **/

public class Proxy implements ProxySubject {

    RealProxySubject realSubject;
    String msg;

    public Proxy(String msg){
        this.msg = msg;
    }

    @Override
    public void request() {
        if(realSubject==null){
            realSubject = new RealProxySubject(msg);
        }
        realSubject.request();
    }
}
