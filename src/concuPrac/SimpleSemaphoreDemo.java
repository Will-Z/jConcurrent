package concuPrac;

import java.sql.Time;
import java.util.concurrent.*;

/**
 * @author will
 * @date 2019/12/9
 */
public class SimpleSemaphoreDemo {
    public static void main(String[] args) {
        Semaphore sema = new Semaphore(5);
        Runnable r = () -> {
            try {
                sema.acquire();
                Thread.sleep(700);
                System.out.println(Thread.currentThread().getId() + "  done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                sema.release();
            }
        };

        ExecutorService ex = Executors.newFixedThreadPool(20);
//        ExecutorService ex = new ThreadPoolExecutor(20, 20, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

        for (int i = 0; i < 20; i++) {
            ex.submit(r);
        }
        ex.shutdown();


    }
}
