package play.thread.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池的扩展;  使用 beforeExecute() afterExecute() 跟踪线程池运行状态
 * @author will
 * @date 2019/3/4
 */
public class ExtThreadPool {
    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            System.out.println("正在执行 threadId: " + Thread.currentThread().getId() + "    name: "
                    + Thread.currentThread().getName());
        };

        ExecutorService es = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>()) {

            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("准备执行: " + t.getName());
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {

            }

            @Override
            protected void terminated() {
                System.out.println("线程池退出");
            }
        };

        for (int i = 0; i < 5; i++) {
//            es.submit(r);
            es.execute(r);
            Thread.sleep(10);

        }

        es.shutdown();



    }

}
