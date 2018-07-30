package thinkInJava.concurrent.four.one;

import java.util.Random;

/**
 * @author Will
 * @date 2018/7/30.
 */
public class Count {
    private int count = 0;
    private Random rand = new Random(47);

    public synchronized int increment() {
        int temp = count;
        if (rand.nextBoolean()) {
            Thread.yield();
        }
        return (count = ++temp);
    }

    public synchronized int value() {
        return count;
    }
}
