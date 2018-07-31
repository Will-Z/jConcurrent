package thinkInJava.concurrent.five.three.con;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Will
 * @date 2018/7/31.
 */
public class Car {
    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    private boolean waxOn = false;

    public void waxed() {
        lock.lock();
        try {
            waxOn = true;  // ready to buff
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void buffed() {
        lock.lock();
        try {
            waxOn = false;    // ready for another coat of wax
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void waitForWaxing() throws InterruptedException {
        lock.lock();
        try {
            while (!waxOn) {
                condition.await();
            }
        } finally {
            lock.unlock();
        }
    }

    public void waitForBuffing() throws InterruptedException {
        lock.lock();
        try {
            while (waxOn) {
                condition.await();
            }
        } finally {
            lock.unlock();
        }
    }
}
