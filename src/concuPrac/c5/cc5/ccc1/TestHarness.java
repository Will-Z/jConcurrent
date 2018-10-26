package concuPrac.c5.cc5.ccc1;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * 在计时测试中使用 CountDownLatch来启动和停止线程
 *
 * @author Will
 * @date 2018/9/10.
 */
public class TestHarness {
    public static long timeTasks(int nThreads, final Runnable task) throws Exception {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                @Override public void run() {
                    try {
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException ignore) {}
                }
            };
            t.start();
        }

        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();

        return end - start;
    }

    public static void main(String[] args) throws Exception{
        Random rand = new Random(47);

        long time = timeTasks(20, () -> {
            int sum = 0;
            for (int i = 0; i < 10000; i++) {
                sum = (sum + rand.nextInt()) / 1024;
            }
        });

        System.out.println(time);

    }
}
