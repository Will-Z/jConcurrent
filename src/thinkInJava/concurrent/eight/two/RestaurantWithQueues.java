package thinkInJava.concurrent.eight.two;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Will
 * @date 2018/8/5.
 */
public class RestaurantWithQueues {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        Restaurant restaurant = new Restaurant(exec, 5, 2);
        exec.execute(restaurant);

        System.out.println("Press 'Enter' to quit ");
        System.in.read();

        exec.shutdownNow();
    }
}
