package thinkInJava.concurrent.three.two;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * ReetrantLock 允许你尝试着获取但最终未获取锁;
 * 显式的Lock对象在加锁和释放方面, 相对于内建的synchronized锁来说 更加灵活
 *
 * @author Will
 * @date 2018/7/19.
 */
public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();

    public void untimed() {
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock():  " + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public void timed() {
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println("tryLock(2, TimeUnit.SECONDS): " + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        final AttemptLocking al = new AttemptLocking();
        al.untimed();
        al.timed();

        new Thread() {
            {
                setDaemon(true);
            }
            @Override public void run () {
                al.lock.lock();
                System.out.println("acquired");
            }
        }.start();


//        Thread.yield();

        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        al.untimed();
        al.timed();
    }
}
