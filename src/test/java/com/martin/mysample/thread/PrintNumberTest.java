package com.martin.mysample.thread;

import com.martin.mysample.demo.thread.PrintNumber;
import org.junit.jupiter.api.Test;

/**
 * PrintNumberTest
 *
 * @author Martin
 * @since 2023-10-19 09:55
 **/

public class PrintNumberTest {

    @Test
    public void testPrint() {
        PrintNumber p = new PrintNumber();

        Thread t1 = new Thread(p);
        Thread t2 = new Thread(p);

        t1.start();
        t2.start();
    }
}
