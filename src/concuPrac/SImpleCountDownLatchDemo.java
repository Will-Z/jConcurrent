package concuPrac;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author will
 * @date 2019/12/9
 */
public class SImpleCountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException{
        CountDownLatch end = new CountDownLatch(10);
        Runnable r = () -> {
            try {
                Thread.sleep(new Random().nextInt(3) * 500);
                System.out.println(Thread.currentThread().getId() + " thread finished");
                end.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        ExecutorService ex = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            ex.submit(r);
        }
        end.await();
        System.out.println("all finished");
        ex.shutdown();




    }
}
