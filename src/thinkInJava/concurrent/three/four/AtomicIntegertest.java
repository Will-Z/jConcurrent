package thinkInJava.concurrent.three.four;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * [T]
 *
 * 使用AtomicInteger 重写了 AtomicityTest.java;
 * 通过使用 AtomicInteger  消除了 synchronized关键字; 且保证了正确性;
 *
 * p.s.因为程序不会失败 所以添加了一个Timer,  5s之后自动终止
 *
 * @author Will
 * @date 2018/7/20.
 */
public class AtomicIntegertest implements Runnable{
    private AtomicInteger i = new AtomicInteger(0);

    public int getValue() {
        return i.get();
    }

    private void evenIncrement() {
        i.addAndGet(2);
    }

    @Override public void run() {
        while (true) {
            evenIncrement();
        }
    }

    public static void main(String[] args) {

        // Terminate after 5 seconds
        new Timer().schedule(new TimerTask() {
            @Override public void run() {
                System.err.println("Aborting");
                System.exit(0);
            }
        }, 5000);

        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicIntegertest ait = new AtomicIntegertest();
        exec.execute(ait);

        while (true) {
            int val = ait.getValue();
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
