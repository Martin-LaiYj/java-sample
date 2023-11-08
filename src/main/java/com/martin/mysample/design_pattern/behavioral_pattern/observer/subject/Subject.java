package com.martin.mysample.design_pattern.behavioral_pattern.observer.subject;

import com.martin.mysample.design_pattern.behavioral_pattern.observer.observer.Observer;

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
