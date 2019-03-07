package play.thread.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 使用自定义的 ThreadFactory来创建线程
 * @author will
 * @date 2019/3/4
 */
public class ThreadFactoryDemo {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            System.out.println(System.currentTimeMillis() + "  thread id:  " + Thread.currentThread().getId());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        ExecutorService es = new ThreadPoolExecutor( 5, 5,
                0L, TimeUnit.MILLISECONDS,
                new SynchronousQueue<Runnable>(),
                (Runnable r) -> {
                    Thread t = new Thread(r);

                    // 将所有线程设置为守护线程, 这样 当主线程退出后, 将会强制销毁线程池
                    t.setDaemon(true);
                    System.out.println("create " + t);
                    return t;
                }
        );


        for (int i = 0; i < 5; i++) {
            es.submit(task);
        }
        Thread.sleep(2000);
//        es.shutdown();
    }
}
