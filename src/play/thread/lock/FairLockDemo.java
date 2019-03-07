package play.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author will
 * @date 2019/2/27
 */
public class FairLockDemo {
    static Lock unfairLock = new ReentrantLock();
    static Lock fairLock = new ReentrantLock(true);

    public static void main(String[] args) {
        Runnable r0 = () -> {
            while (!Thread.interrupted()) {
                try {
                    fairLock.lock();
                    System.out.println(Thread.currentThread().getName() + "  [get the lock]");
                } finally {
                    fairLock.unlock();
                }
            }
        };

        var t1 = new Thread(r0, "gg");
        var t2 = new Thread(r0, "mm");
        t1.start();
        t2.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
        t2.interrupt();
    }



}
