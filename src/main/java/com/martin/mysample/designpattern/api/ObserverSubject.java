package com.martin.mysample.designpattern.api;

import com.martin.mysample.designpattern.business.Observer;

/**
 * ObserverSubject
 *
 * @author Martin
 * @since 2023-11-03 17:12
 **/

public interface ObserverSubject {

    public abstract void attach(Observer observer);

    public abstract void detach(Observer observer);

    public abstract void obNotify();
}
