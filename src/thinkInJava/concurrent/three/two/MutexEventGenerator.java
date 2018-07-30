package thinkInJava.concurrent.three.two;

import thinkInJava.concurrent.three.one.EvenChecker;
import thinkInJava.concurrent.three.one.IntGenerator;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * [T]
 *
 * 使用显式的Lock对象
 *
 * @author Will
 * @date 2018/7/19.
 */
public class MutexEventGenerator  extends IntGenerator {
    private int currentEvenValue = 0;
    private Lock lock = new ReentrantLock();

    @Override public int next() {
        lock.lock();
        try {
            ++currentEvenValue;
            ++currentEvenValue;
            return currentEvenValue;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EvenChecker.test(new MutexEventGenerator());
    }
}
