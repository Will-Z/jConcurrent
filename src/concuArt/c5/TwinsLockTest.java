package concuArt.c5;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @author Will
 * @date 2018/10/8.
 */
public class TwinsLockTest {
    public static void main(String[] args) {
        final Lock lock = new TwinsLock();
        class Worker extends Thread {
            @Override public void run() {
                while (true) {
                    lock.lock();
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println(Thread.currentThread().getName());
                        TimeUnit.SECONDS.sleep(1);
                    } catch (Exception e) {
                        // ignore
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }

        // 启动10个线程
        for (int i = 0; i < 10; i++) {
            Worker w = new Worker();
            w.setDaemon(true);
            w.start();
        }

        // 每隔1s换行
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println();
            } catch (Exception e) {
                // ignore
            }
        }
    }
}
