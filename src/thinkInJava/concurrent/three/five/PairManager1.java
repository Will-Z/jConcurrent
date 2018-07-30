package thinkInJava.concurrent.three.five;

/**
 *
 * Synchronize the entire method
 *
 * @author Will
 * @date 2018/7/20.
 */
public class PairManager1 extends PairManager {

    @Override public synchronized void increment() {
        p.incrementX();
        p.incrementY();
        store(getPair());
    }
}
