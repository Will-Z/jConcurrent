package thinkInJava.concurrent.four.three;

/**
 * @author Will
 * @date 2018/7/30.
 */
public class SynchronizedBlocked implements Runnable {
    public synchronized void f() {

        // never releases lock
        while (true) {
            Thread.yield();
        }
    }

    public SynchronizedBlocked() {
        new Thread(() -> {f();}).start();
    }

    @Override public void run() {
        System.out.println("Try to call f()");
        f();
        System.out.println("Exiting SynchronizedBlocked.run()");

    }
}
