package com.martin.mysample.juc;

import com.martin.mysample.juc.bussiness.*;
import com.martin.mysample.utils.UnsafeUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import sun.misc.Unsafe;

import java.util.concurrent.*;
import java.util.concurrent.atomic.LongAdder;

/**
 * JUCTest
 *
 * @author Martin
 * @since 2023-11-04 15:54
 **/

@Slf4j
public class JUCTest {

    @Test
    public void testFixedThreadPool() {
        // 提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor pool = (ThreadPoolExecutor) service;
        pool.setMaximumPoolSize(50);

        service.execute(new Runnable1());
        service.execute(new Runnable2());

        try {
            Future future = service.submit(new Callable1());
            System.out.println("sum = " + future.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        service.shutdown();
    }

    @Test
    public void testVolatile() throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        VolatileAtomicDemo volatileAtomicDemo = new VolatileAtomicDemo();
        for (int i = 0; i < 5; i++) {
            threadPool.execute(() -> {
                for (int j = 0; j < 500; j++) {
                    // volatileAtomicDemo.increase();
                    // volatileAtomicDemo.atomicIncrease();
                    // volatileAtomicDemo.synIncrease();
                    volatileAtomicDemo.lockIncrease();
                }
            });
        }
        // 等待1.5秒，保证上面程序执行完成
        Thread.sleep(1500);
        System.out.println(VolatileAtomicDemo.i);
        // System.out.println(VolatileAtomicDemo.ai);
        threadPool.shutdown();
    }

    LongAdder longAdder = new LongAdder();

    @Test
    public void testLongAdder() throws InterruptedException {
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(50);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20,
                60, TimeUnit.SECONDS, queue);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 500; j++) {
                threadPoolExecutor.execute(new Thread(() -> {
                    longAdder.add(1L);
                }));
            }
        }
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("longAdder = " + longAdder);
    }

    @Test
    public void testCAS() {
        CASDemo casDemo = new CASDemo();
        new Thread(() -> {
            for (int i = 1; i < 5; i++) {
                casDemo.increase(i);
            }
        }).start();
        new Thread(() -> {
            for (int i = 5; i < 10; i++) {
                casDemo.increase(i);
            }
        }).start();
    }

    @Test
    public void testUnsafe() {
        UnsafeDemo unsafeDemo = new UnsafeDemo();
        new Thread(unsafeDemo).start();
        Unsafe unsafe = UnsafeUtils.reflectGetUnsafe();
        // Unsafe unsafe = null;

        while (true) {
            boolean flag = unsafeDemo.isFlag();
            assert unsafe != null;
            unsafe.loadFence();
            if (flag) {
                System.out.println(Thread.currentThread().getName() + " detected flag changed:" + flag);
                break;
            }
        }
        System.out.println("Main thread end!");
    }

}
