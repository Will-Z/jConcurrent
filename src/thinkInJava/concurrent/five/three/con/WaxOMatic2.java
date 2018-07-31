package thinkInJava.concurrent.five.three.con;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * 使用显式的 Lock 和 condition对象 重写 WaxOMatic
 *
 * @author Will
 * @date 2018/7/31.
 */
public class WaxOMatic2 {
    public static void main(String[] args) throws Exception {
        Car car = new Car();

        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));

        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
