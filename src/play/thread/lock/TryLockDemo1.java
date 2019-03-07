package play.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author will
 * @date 2019/2/27
 */
public class TryLockDemo1 {
    static ReentrantLock lock0 = new ReentrantLock();
    static ReentrantLock lock1 = new ReentrantLock();

    static int count0 = 0;
    static int count1 = 0;

    public static void main(String[] args) {
        Runnable r0 = () -> {
            while (true) {
                if (lock0.tryLock()) {
                    try {
//                        try {
//                            Thread.sleep(500);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                        count0++;
                        if (lock1.tryLock()) {
                            try {
                                System.out.println(Thread.currentThread().getName() + "  [done] " + count0);
                                return;
                            } finally {
                                lock1.unlock();
                            }
                        }
                    } finally {
                        lock0.unlock();
                    }
                }
            }
        };
        Runnable r1 = () -> {
            while (true) {
                if (lock1.tryLock()) {
                    try {
//                        try {
//                            Thread.sleep(500);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                        count1++;
                        if (lock0.tryLock()) {
                            try {
                                System.out.println(Thread.currentThread().getName() + "  [done] " + count1);
                                return;
                            } finally {
                                lock0.unlock();
                            }
                        }
                    } finally {
                        lock1.unlock();
                    }
                }
            }
        };

        new Thread(r0).start();
        new Thread(r1).start();
    }
}
