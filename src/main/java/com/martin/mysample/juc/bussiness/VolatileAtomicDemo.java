package com.martin.mysample.juc.bussiness;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author martin
 */

public class VolatileAtomicDemo {

    public volatile static int i = 0;

    Lock lock = new ReentrantLock();


    public volatile static AtomicInteger ai = new AtomicInteger(0);

    public void increase() {
        i++;
    }

    public synchronized void synIncrease() {
        i++;
    }

    public void lockIncrease() {
        lock.lock();
        try {
            i++;
        } finally {
            lock.unlock();
        }
    }

    public void atomicIncrease() {
        ai.getAndIncrement();
    }

}