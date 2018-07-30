package thinkInJava.concurrent.three.seven;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 线程本地存储
 *
 * @author Will
 * @date 2018/7/20.
 */
public class ThreadLocalVariableHolder {
    private static ThreadLocal<Integer> value =
        new ThreadLocal<Integer>() {
            private Random rand = new Random(47);
            @Override protected synchronized Integer initialValue() {
                return rand.nextInt(10000);
            }
        };

    public static void increment() {
        value.set(value.get() + 1);
    }

    public static int get() {
        return value.get();
    }

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Accessor(i));
        }

            // Run for a while
            TimeUnit.SECONDS.sleep(1);
            exec.shutdownNow();
    }
}
