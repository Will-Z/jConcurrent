package thinkInJava.concurrent.three.five.explicit;

import thinkInJava.concurrent.three.five.Pair;
import thinkInJava.concurrent.three.five.PairManager;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * use a critical section
 *
 * @author Will
 * @date 2018/7/20.
 */
public class ExplicitPairManager2 extends PairManager {
    private Lock lock = new ReentrantLock();

    @Override public void increment() {
        Pair temp;
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        } finally {
            lock.unlock();
        }

//        synchronized(this) {
//            p.incrementX();
//            p.incrementY();
//            temp = getPair();
//        }


        store(temp);
    }
}
