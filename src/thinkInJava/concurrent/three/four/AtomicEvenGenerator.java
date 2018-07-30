package thinkInJava.concurrent.three.four;

import thinkInJava.concurrent.three.one.EvenChecker;
import thinkInJava.concurrent.three.one.IntGenerator;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * [T]
 *
 * 用AtomicInteger 重写了MutexEvenGenerator
 *
 * @author Will
 * @date 2018/7/20.
 */
public class AtomicEvenGenerator extends IntGenerator {
    private AtomicInteger currentEvenValue = new AtomicInteger(0);

    @Override public int next() {
        return currentEvenValue.addAndGet(2);
    }

    public static void main(String[] args) {
        EvenChecker.test(new AtomicEvenGenerator());
    }
}
