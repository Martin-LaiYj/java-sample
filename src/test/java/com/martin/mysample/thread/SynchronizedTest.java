package com.martin.mysample.thread;

import org.junit.jupiter.api.Test;

class SynchronizedTest {

    @Test
    public void testTicket() {
        Window p = new Window();

        Thread t1 = new Thread(p);
        Thread t2 = new Thread(p);
        Thread t3 = new Thread(p);

        t1.start();
        t2.start();
        t3.start();

//        System.out.println(Window.soldTicketMap.size());
    }

    @Test
    public void testTicketBloak(){
        WindowBlock p = new WindowBlock();

        Thread t1 = new Thread(p);
        Thread t2 = new Thread(p);
        Thread t3 = new Thread(p);

        t1.start();
        t2.start();
        t3.start();
    }

}