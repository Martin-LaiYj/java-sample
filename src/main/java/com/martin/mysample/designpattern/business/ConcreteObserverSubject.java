package com.martin.mysample.designpattern.business;

import com.martin.mysample.designpattern.api.ObserverSubject;

import java.util.ArrayList;
import java.util.List;

/**
 * RealObserverSubject
 *
 * @author Martin
 * @since 2023-11-03 17:14
 **/

public class ConcreteObserverSubject implements ObserverSubject {

    String subjectState;

    List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void obNotify() {
        observers.forEach(Observer::update);
    }

    public void updateState(String newState){
        this.subjectState = newState;
        obNotify();
    }

    public String getState() {
        return subjectState;
    }
}
