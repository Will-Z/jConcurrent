package thinkInJava.concurrent.seven.four;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author Will
 * @date 2018/8/2.
 */
public class PriorityBlockingQueueDemo {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();

        PriorityBlockingQueue<Runnable> queue = new PriorityBlockingQueue<>();

        exec.execute(new PrioritizedTaskProducer(queue, exec));
        exec.execute(new PrioritizedTaskConsumer(queue));
    }
}
