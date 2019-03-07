package play.thread.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 *  信号量
 *
 * @author will
 * @date 2019/2/28
 */
public class SemaDemo {
    static Semaphore sema = new Semaphore(5);

    public static void main(String[] args) {
        Runnable r = () -> {
            try {
                sema.acquire();
                System.out.println(Thread.currentThread().getName() + "  " + Thread.currentThread().getId());
                Thread.sleep(1000);
                sema.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        ExecutorService exec = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            exec.submit(r);
        }
        exec.shutdown();

    }


}
