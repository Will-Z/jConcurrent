package thinkInJava.concurrent.three.two;

import thinkInJava.concurrent.three.one.EvenChecker;
import thinkInJava.concurrent.three.one.IntGenerator;

/**
 * 使用 synchronized方法 进行同步控制
 *
 * @author Will
 * @date 2018/7/19.
 */
public class SynchronizedEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    @Override public synchronized int next() {
        ++currentEvenValue;
        ++currentEvenValue;
        return 0;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
