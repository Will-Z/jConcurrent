package thinkInJava.concurrent.three.five;

/**
 *
 * Use a critical section;
 *
 * @author Will
 * @date 2018/7/20.
 */
public class PairManager2 extends PairManager {
    @Override public void increment() {
        Pair  temp;
        synchronized(this) {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        }
        store(temp);
    }
}
