package thinkInJava.concurrent.three.three;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * [F]
 *
 * 1) getValue() 缺少同步, 所以其数值可能会在不稳定的中间状态被读取
 * 2) i 不是volatile的  存在可视性问题
 *
 * p.s.  getValue() 与 evenIncrement() 必须是synchronized
 *
 * @author Will
 * @date 2018/7/19.
 */
public class AtomicityTest implements Runnable {
    private int i = 0;

    public int getValue() {
        return i;
    }

    private synchronized void evenIncrement() {
        i++;
        i++;
    }

    @Override public void run() {
        while (true) {
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        exec.execute(at);
        while (true) {
            int val = at.getValue();
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
