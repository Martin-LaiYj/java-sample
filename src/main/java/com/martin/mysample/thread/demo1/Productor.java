package com.martin.mysample.thread.demo1;

import com.martin.mysample.thread.demo1.Clerk;

/**
 * Productor
 *
 * @author Martin
 * @since 2023-10-19 11:55
 **/

public class Productor extends Thread {

    Clerk clerk;

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            clerk.product();
        }
    }

    public Productor(Clerk clerk, String name) {
        this.clerk = clerk;
        setName(name);
    }
}
