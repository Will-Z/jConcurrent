package thinkInJava.concurrent.seven.one;

import java.util.concurrent.CountDownLatch;

/**
 * Waits on the CountDownLatch
 *
 * @author Will
 * @date 2018/8/1.
 */
public class WaitingTask implements Runnable  {
    private static int counter = 0;
    private int id = counter++;
    private CountDownLatch latch;

    public WaitingTask(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override public String toString() {
        return String.format("WaitingTask %1$-3d ", id);
    }

    @Override public void run() {
        try {
            latch.await();
            System.out.println("Latch barrier passed for " + this);
        } catch (InterruptedException e) {
            System.out.println(this + "interrupted");
        }
    }
}
