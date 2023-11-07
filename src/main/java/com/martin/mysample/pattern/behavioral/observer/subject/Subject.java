package com.martin.mysample.pattern.behavioral.observer.subject;

import com.martin.mysample.pattern.behavioral.observer.observer.Observer;

/**
 * Subject
 *
 * @author Martin
 * @since 2023-11-03 17:12
 **/

public interface Subject {

    public abstract void attach(Observer observer);

    public abstract void detach(Observer observer);

    public abstract void obNotify();
}
