package com.martin.mysample.thread.demo1;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * Clerk
 *
 * @author Martin
 * @since 2023-10-19 11:55
 **/

@Data
public class Clerk implements Runnable {

    private static int product_count = 0;

    static final int MAX_PRODUCT_COUNT = 20;

    static final String PRODUCTOR_NAME = "生产者";

    static final String CUSTOMER_NAME = "消费者";

    public synchronized void product() {
        if (product_count >= MAX_PRODUCT_COUNT) {
            System.out.println(Thread.currentThread().getName() + ":停止生产，当前剩余商品" + product_count);
            // 阻塞生产者生产商品
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            notifyAll();
            System.out.println(Thread.currentThread().getName() + ":商品+1，当前剩余商品" + ++product_count);
        }

    }

    public synchronized void consume() {
        if (product_count <= 0) {
            System.out.println(Thread.currentThread().getName() + ":停止取商品，当前剩余商品" + product_count);
            // 阻塞消费者取商品
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            notifyAll();
            System.out.println(Thread.currentThread().getName() + ":商品-1，当前剩余商品" + --product_count);
        }

    }

    @Override
    public void run() {
        while (true) {
//            try {
//                Thread.sleep(5);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }

            if (StringUtils.contains(Thread.currentThread().getName(), PRODUCTOR_NAME)) {
                // 唤醒消费者来取走商品
//                    notify();

            } else {
                // 唤醒生产者生产商品
//                    notify();

            }
        }

    }

    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Productor productor = new Productor(clerk, PRODUCTOR_NAME);
        productor.setPriority(6);
        Customer customer1 = new Customer(clerk, CUSTOMER_NAME + "1");
        Customer customer2 = new Customer(clerk, CUSTOMER_NAME + "2");

//        clerk.setProductor(productor);
//        clerk.setCustomer(customer);

        productor.start();
        customer1.start();
        customer2.start();
    }
}
