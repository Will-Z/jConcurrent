package play.thread.threadPool;

import java.util.concurrent.*;

/**
 * 自定义线程池 和 拒绝策略
 *
 * @author will
 * @date 2019/3/4
 */
public class RejectThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            System.out.println(System.currentTimeMillis() + "  thread id:  " + Thread.currentThread().getId());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        ExecutorService es = new ThreadPoolExecutor(5, 5,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(10),
                Executors.defaultThreadFactory(),
                (Runnable r, ThreadPoolExecutor e) -> {
                    System.out.println(r.toString() + "  is discard!!");
                }
        );

        for (int i = 0; i < 100; i++) {
            es.submit(task);
            Thread.sleep(10);
        }
        es.shutdown();


    }
}
