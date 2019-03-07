package play.thread.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author will
 * @date 2019/3/1
 */
public class FixedThreadPollDemo {
    public static void main(String[] args) {
        Runnable r = () -> {
            System.out.println(System.currentTimeMillis() + "  " + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            exec.submit(r);
        }
        exec.shutdown();

    }
}
