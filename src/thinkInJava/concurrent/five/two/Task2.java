package thinkInJava.concurrent.five.two;

/**
 * @author Will
 * @date 2018/7/31.
 */
public class Task2 implements Runnable {
    // A separate Blocker object;
    static Blocker blocker = new Blocker();

    @Override public void run() {
        blocker.waitingCall();
    }
}
