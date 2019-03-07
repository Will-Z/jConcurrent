package play.thread.count;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch
 *
 * @author will
 * @date 2019/2/28
 */
public class CountDownLatchDemo {
    static CountDownLatch end = new CountDownLatch(10);

    public static void main(String[] args) throws InterruptedException{
        Runnable r = () -> {
            try {
                Thread.sleep(new Random().nextInt(3) *500);
                System.out.println("[count thread]  " + Thread.currentThread().getName());
                end.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        ExecutorService exec = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            exec.submit(r);
        }

        end.await();
        System.out.println("--------------------------------------------- :)");
        exec.shutdown();



    }
}
