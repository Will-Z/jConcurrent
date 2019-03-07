package play.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock  限时等待
 *
 * @author will
 * @date 2019/2/26
 */
public class TryLockDemo {
    public static void main(String[] args) {
        var lock = new ReentrantLock();

        Runnable r = () -> {
            try {
                if (lock.tryLock(1, TimeUnit.SECONDS)) {
                    System.out.println(Thread.currentThread().getName() + "  held the lock" );
                    Thread.sleep(3000);
                } else {
                    System.out.println(Thread.currentThread().getName() + "  get lock failed");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (lock.isHeldByCurrentThread()) {
                    lock.unlock();
                }
            }
        };

        var t0 = new Thread(r);
        var t1 = new Thread(r);
        t0.start();
        t1.start();



    }
}
