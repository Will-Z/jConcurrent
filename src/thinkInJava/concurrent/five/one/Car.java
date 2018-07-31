package thinkInJava.concurrent.five.one;

/**
 * @author Will
 * @date 2018/7/31.
 */
public class Car {
    private boolean waxOn = false;

    public synchronized void waxed() {
        // ready to buff
        waxOn = true;
        notifyAll();
    }

    public synchronized void buffed() {
        // Ready to another coat of wax
        waxOn = false;
        notifyAll();
    }

    public synchronized void waitForWaxing() throws InterruptedException {
        while (!waxOn) {
            wait();
        }
    }

    public synchronized void waitForBuffing() throws InterruptedException {
        while (waxOn) {
            wait();
        }
    }
}
