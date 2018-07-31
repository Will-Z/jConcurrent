package thinkInJava.concurrent.five.two;

/**
 * @author Will
 * @date 2018/7/31.
 */
public class Blocker {
    synchronized void waitingCall() {
        try {
            while (!Thread.interrupted()) {
                wait();
                System.out.println(Thread.currentThread() + " ");
            }
        } catch (InterruptedException e) {
            // Ok to exit this way
        }
    }

    synchronized void prod() {
        notify();
    }

    synchronized void prodAll() {
        notifyAll();
    }
}
