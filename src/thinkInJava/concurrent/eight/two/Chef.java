package thinkInJava.concurrent.eight.two;


import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Will
 * @date 2018/8/5.
 */
public class Chef implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private Restaurant restaurant;
    private static Random rand = new Random(47);

    public Chef(Restaurant rest) {
        restaurant = rest;
    }

    @Override public void run() {
        try {
            while (!Thread.interrupted()) {
                // blocks until an order appears:
                Order order = restaurant.orders.take();
                Food requestedItem = order.item();
                // Time to prepare order:
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                Plate plate = new Plate(order, requestedItem);
                order.getWaitPerson().filledOrders.put(plate);
            }
        } catch (InterruptedException e) {
            System.out.println(this + " interrupted");
        }
        System.out.println(this + " off duty");
    }

    @Override public String toString() {
        return "Chef " + id + "  ";
    }
}
