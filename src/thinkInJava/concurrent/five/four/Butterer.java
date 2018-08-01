package thinkInJava.concurrent.five.four;

/**
 * apply butter to toast
 *
 * @author Will
 * @date 2018/8/1.
 */
public class Butterer implements Runnable {
    private ToastQueue dryQueue, butteredQueue;

    public Butterer(ToastQueue dry, ToastQueue buttered) {
        dryQueue = dry;
        butteredQueue = buttered;
    }

    @Override public void run() {
        try {
            while (!Thread.interrupted()) {
                // Blocks until next piece of toast is available;
                Toast t = dryQueue.take();
                t.butter();
                System.out.println(t);
                butteredQueue.put(t);
            }
        } catch (InterruptedException e) {
            System.out.println("Butterer interrupted");
        }
        System.out.println("Butterer off");
    }
}
