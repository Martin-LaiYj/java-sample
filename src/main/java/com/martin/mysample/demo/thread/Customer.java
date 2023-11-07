package com.martin.mysample.demo.thread;

/**
 * Customer
 *
 * @author Martin
 * @since 2023-10-19 11:56
 **/

public class Customer extends Thread {

    Clerk clerk;

    public Customer(Clerk clerk, String name) {
        this.clerk = clerk;
        setName(name);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            clerk.consume();
        }
    }
}
