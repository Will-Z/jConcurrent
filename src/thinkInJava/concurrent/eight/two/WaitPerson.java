package thinkInJava.concurrent.eight.two;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Will
 * @date 2018/8/5.
 */
public class WaitPerson implements  Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private Restaurant restaurant;

    BlockingQueue<Plate> filledOrders = new LinkedBlockingQueue<>();

    public WaitPerson(Restaurant rest) {
        restaurant = rest;
    }

    public void placeOrder(Customer cust, Food food) {
        try {
            // shouldn't actually block because this is
            // a LinkedBlockingQueue with no size limit
            restaurant.orders.put(new Order(cust, this, food));
        } catch (InterruptedException e) {
            System.out.println(this + " placeOrder interrupted");
        }
    }

    @Override public void run() {
        try {
            while (!Thread.interrupted()) {
                // blocks until a course is ready
                Plate plate = filledOrders.take();
                System.out.println(this + "received" + plate + " delivering to " +
                    plate.getOrder().getCustomer());
                plate.getOrder().getCustomer().deliver(plate);
            }
        } catch (InterruptedException e) {
            System.out.println(this + " interrupted");
        }
        System.out.println(this + " off duty");
    }

    @Override public String toString() {
        return "WaitPerson " + id + " ";
    }
}
