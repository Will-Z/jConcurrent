package thinkInJava.concurrent.four.three;

import java.util.concurrent.TimeUnit;

/**
 * @author Will
 * @date 2018/7/30.
 */
public class SleepBlocked implements  Runnable {

    @Override public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch(InterruptedException e) {
            System.out.println("InterruptedException");
        }
        System.out.println("Exiting SleepBlocked.run()");
    }
}
