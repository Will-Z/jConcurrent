package thinkInJava.concurrent.seven.one;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Will
 * @date 2018/8/1.
 */
public class CountDownLatchDemo {
    static final int SIZE = 100;

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();

        // All must share a single CountDownLatch object
        CountDownLatch latch = new CountDownLatch(SIZE);
        for (int i = 0; i < 10; i++) {
            exec.execute(new WaitingTask(latch));
        }
        for (int i = 0; i < SIZE; i++) {
            exec.execute(new TaskPortion(latch));
        }

        System.out.println("Launch all tasks");
        exec.shutdown();   // Quit when all tasks complete

    }
}
