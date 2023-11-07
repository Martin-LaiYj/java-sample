package com.martin.mysample.pattern.behavioral.observer.observer;

import com.martin.mysample.pattern.behavioral.observer.subject.ConcreteSubject;

/**
 * ConcreteObserver
 *
 * @author Martin
 * @since 2023-11-03 17:19
 **/

public class ConcreteObserver extends Observer {

    protected ConcreteSubject subject;

    private String subjectState;

    private String name;

    public ConcreteObserver(ConcreteSubject subject, String name) {
        this.subject = subject;
        this.name = name;
    }

    @Override
    public void update() {
        subjectState = subject.getState();
        System.out.println(name + " received update. New state: " + subjectState);
    }
}
