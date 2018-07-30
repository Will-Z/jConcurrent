package thinkInJava.concurrent.three.five;

/**
 * @author Will
 * @date 2018/7/20.
 */
public class PairManipulator implements Runnable {
    private PairManager pm;

    public PairManipulator(PairManager pm) {
        this.pm = pm;
    }

    @Override public void run() {
        while (true) {
            pm.increment();
        }
    }

    @Override public String toString() {
        return "Pair: " + pm.getPair() + " checkCounter = " + pm.checkCounter.get();
    }
}
