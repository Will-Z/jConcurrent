package thinkInJava.concurrent.eight.three;

/**
 * @author Will
 * @date 2018/8/6.
 */
public class Reporter implements Runnable {
    private CarQueue carQueue;

    public Reporter(CarQueue cq) {
        carQueue = cq;
    }

    @Override public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println(carQueue.take());
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting Reporter via interrupt");
        }
        System.out.println("Reporter off");
    }
}
