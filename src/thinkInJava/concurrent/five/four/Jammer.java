package thinkInJava.concurrent.five.four;

/**
 * @author Will
 * @date 2018/8/1.
 */
public class Jammer implements Runnable {
    private ToastQueue butteredQueue, finishedQueue;

    public Jammer(ToastQueue buttered, ToastQueue finished) {
        butteredQueue = buttered;
        finishedQueue = finished;
    }

    @Override public void run() {
        try {
            while (!Thread.interrupted()) {
                // Blocks until next piece of toast is available;
                Toast t = butteredQueue.take();
                t.jam();
                System.out.println(t);
                finishedQueue.put(t);
            }
        } catch (InterruptedException e) {
            System.out.println("Jammer interrupted");
        }
        System.out.println("Jammer off");
    }
}
