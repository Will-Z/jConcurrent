package thinkInJava.concurrent.five.one;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Will
 * @date 2018/7/31.
 */
public class WaxOMatic {
    public static void main(String[] args) throws Exception {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));


        // run for a while
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
