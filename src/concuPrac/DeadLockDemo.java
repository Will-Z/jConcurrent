package concuPrac;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 竞争一系列资源顺序不同导致死锁
 *
 * @author will
 * @date 2019/12/9
 */
public class DeadLockDemo {
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Runnable r1 = () -> {
            try {
                lock1.lockInterruptibly();
                System.out.println(Thread.currentThread().getId() + "线程获得lock1");
                Thread.sleep(500);
                lock2.lockInterruptibly();
                System.out.println(Thread.currentThread().getId() + "线程获得lock2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                if (lock1.isHeldByCurrentThread()) {
                    lock1.unlock();
                }
                if (lock2.isHeldByCurrentThread()) {
                    lock2.unlock();
                }
                System.out.println(Thread.currentThread().getId() + " 线程退出");

            }
        };

        Runnable r2 = () -> {
          try {
              lock2.lockInterruptibly();
              System.out.println(Thread.currentThread().getId() + "线程获得lock2");
              Thread.sleep(500);
              lock1.lockInterruptibly();
              System.out.println(Thread.currentThread().getId() + "线程获得lock1");
          } catch (InterruptedException e) {
              e.printStackTrace();
          } finally {
              if (lock1.isHeldByCurrentThread()) {
                  lock1.unlock();
              }
              if (lock2.isHeldByCurrentThread()) {
                  lock2.unlock();
              }
              System.out.println(Thread.currentThread().getId() + " 线程退出");
          }
        };

        Thread t1 = new Thread(r1);
        t1.start();
        new Thread(r2).start();
        Thread.sleep(1000);
        t1.interrupt();
    }



}
