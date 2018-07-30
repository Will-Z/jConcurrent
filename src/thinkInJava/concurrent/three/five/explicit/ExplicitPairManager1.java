package thinkInJava.concurrent.three.five.explicit;

import thinkInJava.concurrent.three.five.PairManager;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * Synchronize the entire method;
 *
 * @author Will
 * @date 2018/7/20.
 */
public class ExplicitPairManager1 extends PairManager {
    private Lock lock = new ReentrantLock();

    @Override public synchronized void increment() {
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            store(getPair());
        } finally {
            lock.unlock();
        }
    }
}
