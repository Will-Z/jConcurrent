package thinkInJava.concurrent.eight.three;

import java.util.concurrent.TimeUnit;

/**
 * @author Will
 * @date 2018/8/6.
 */
public class ChassisBuilder implements Runnable {
    private CarQueue carQueue;
    private int counter = 0;

    public ChassisBuilder(CarQueue cq) {
        carQueue = cq;
    }

    @Override public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(500);
                // make chassis:
                Car c = new Car(counter++);
                System.out.println("ChassisBuilder created " + c);
                carQueue.put(c);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted: ChassisBuilder");
        }
        System.out.println("ChassisBuilder off");
    }
}
