package thinkInJava.concurrent.five.two;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Will
 * @date 2018/7/31.
 */
public class NotifyVsNotifyAll {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {
            exec.execute(new Task());
        }
        exec.execute(new Task2());

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            boolean prod = true;
            @Override  public void run() {
                if (prod) {
                    System.out.println("notify()");
                    Task.blocker.prod();
                    prod = false;
                } else {
                    System.out.println("notifyAll() ");
                    Task.blocker.prodAll();
                    prod = true;
                }
            }
        }, 400, 400); // run every 0.4 second

        TimeUnit.SECONDS.sleep(5);
        timer.cancel();
        System.out.println("Timer canceled");
        TimeUnit.MILLISECONDS.sleep(500);

        System.out.println("Task2.blocker.prodAll() ");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Shutting down");
        exec.shutdownNow();
    }
}
