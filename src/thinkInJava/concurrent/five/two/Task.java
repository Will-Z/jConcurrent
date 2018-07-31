package thinkInJava.concurrent.five.two;

/**
 * @author Will
 * @date 2018/7/31.
 */
public class Task implements Runnable {
    static Blocker blocker = new Blocker();

    @Override public void run() {
        blocker.waitingCall();
    }
}
