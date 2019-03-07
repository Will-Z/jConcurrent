package play.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 死锁
 *
 * p.s.   ReentrancLock 的 lockInterruptibly 在等待锁的过程中可以响应中断
 *
 * @author will
 * @date 2019/2/22
 */
public class DeadLockDemo {
    static ReentrantLock lock1 = new ReentrantLock();
    static ReentrantLock lock2 = new ReentrantLock();

    public static void main(String[] args) throws Exception {
        Runnable r0 = () -> {
            try {
                lock1.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() + "  a");
                Thread.sleep(500);
                lock2.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() + "  b");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (lock1.isHeldByCurrentThread()) {
                    lock1.unlock();
                }
                if (lock2.isHeldByCurrentThread()) {
                    lock2.unlock();
                }
                System.out.println(Thread.currentThread().getId() + " " + Thread.currentThread().getName() + " in end");

            }
        };

        Runnable r1 = () -> {
            try {
                lock2.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() + "  a");
                Thread.sleep(500);
                lock1.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() + "  b");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (lock1.isHeldByCurrentThread()) {
                    lock1.unlock();
                }
                if (lock2.isHeldByCurrentThread()) {
                    lock2.unlock();
                }
                System.out.println(Thread.currentThread().getId() + " " + Thread.currentThread().getName() + " in end");
            }
        };

        var t0 = new Thread(r0);
        var t1 = new Thread(r1);

        t0.start();
        t1.start();

        Thread.sleep(1000);
        System.out.println("where dead lock happen");
        t1.interrupt();


        t0.join();
        t1.join();


    }
}
