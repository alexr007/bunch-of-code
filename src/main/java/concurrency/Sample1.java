package concurrency;


import org.junit.Test;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.assertEquals;

public class Sample1 {
    @Test
    public void situation1() throws InterruptedException {
        Product p = new Product();
        CountDownLatch cdl = new CountDownLatch(2);
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    p.inc();
                }
                cdl.countDown();
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    p.inc();
                }
                cdl.countDown();
            }
        };
        new Thread(r1).start();
        new Thread(r2).start();

        cdl.await();
        assertEquals(20000,p.get());
        System.out.println(p.get());
    }
}
