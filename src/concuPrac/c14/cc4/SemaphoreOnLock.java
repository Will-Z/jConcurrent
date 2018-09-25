package concuPrac.c14.cc4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Lock来实现信号量
 *  p.s. 这并非java.util.concurrent.Semaphore的真实实现方式
 *
 *
 * @author Will
 * @date 2018/9/25.
 */
public class SemaphoreOnLock {
    private final Lock lock = new ReentrantLock();

    // 条件谓词: permitsAvailable (permits > 0)
    private final Condition permitsAvailable = lock.newCondition();

    private int permits;

    SemaphoreOnLock(int initPermits) {
        lock.lock();
        try {
            permits = initPermits;
        } finally {
            lock.unlock();
        }
    }

    // 阻塞并直到 permitsAvailable
    public void acquire() throws InterruptedException {
        lock.lock();
        try {
            while (permits <= 0) {
                permitsAvailable.await();
            }
            permits--;
        } finally {
            lock.unlock();
        }
    }

    public void release() {
        lock.lock();
        try {
            permits++;
            permitsAvailable.signal();
        } finally {
            lock.unlock();
        }
    }



}
