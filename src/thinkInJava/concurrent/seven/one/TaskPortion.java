package thinkInJava.concurrent.seven.one;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author Will
 * @date 2018/8/1.
 */
public class TaskPortion implements Runnable {
    private static int counter = 0;
    private int id = counter++;
    private static Random rand = new Random(47);
    private CountDownLatch latch;

    public TaskPortion(CountDownLatch latch) {
        this.latch = latch;
    }

    public void doWork() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
        System.out.println(this + " completed");
    }

    @Override public String toString() {
        return String.format("%1$-3d ", id);
    }

    @Override public void run() {
        try {
            doWork();
            latch.countDown();
        } catch (InterruptedException e) {
            // Acceptable away to exit
        }
    }

}
