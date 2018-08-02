package thinkInJava.concurrent.seven.four;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author Will
 * @date 2018/8/2.
 */
public class PrioritizedTaskConsumer implements Runnable {
    private PriorityBlockingQueue<Runnable> q;

    public PrioritizedTaskConsumer(PriorityBlockingQueue<Runnable> q) {
        this.q = q;
    }

    @Override public void run() {
        try {
            while (!Thread.interrupted()) {
                // use current thread to run the task
                q.take().run();
            }
        } catch(InterruptedException e) {
            // Acceptable way to exit
        }
        System.out.println("Finished PrioritizedTaskConsumer");
    }
}
