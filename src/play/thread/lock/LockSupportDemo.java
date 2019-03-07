package play.thread.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * @author will
 * @date 2019/2/28
 */
public class LockSupportDemo {
    static Object u = new Object();

    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            synchronized(u) {
                System.out.println(Thread.currentThread().getName() + "  [before]");
                LockSupport.park();
                if (Thread.interrupted()) {
                    System.out.println(Thread.currentThread().getName() + "  [interrupted]");
                }
                System.out.println(Thread.currentThread().getName() + "  [over]");
            }
        };

        Thread t0 = new Thread(r);
        Thread t1 = new Thread(r);

        t0.start();
        Thread.sleep(500);
        t1.start();

        LockSupport.unpark(t0);
//        t0.interrupt();
        LockSupport.unpark(t1);
    }
}
