package play.thread.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author will
 * @date 2019/3/1
 */
public class ScheduledExecutorServiceDemo {
    public static void main(String[] args) {
        Runnable r = () -> {
            try {
                Thread.sleep(1000);
                System.out.println(System.currentTimeMillis() / 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        ScheduledExecutorService ses = Executors.newScheduledThreadPool(10);
        ses.scheduleAtFixedRate(r, 0, 2, TimeUnit.SECONDS);


    }
}
