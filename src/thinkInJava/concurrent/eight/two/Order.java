package thinkInJava.concurrent.eight.two;


/**
 * @author Will
 * @date 2018/8/5.
 */
public class Order {
    private static int counter = 0;
    private final int id = counter++;
    private Customer customer;
    private WaitPerson waitPerson;
    private Food food;

    public Order(Customer cust, WaitPerson wp, Food f) {
        customer = cust;
        waitPerson = wp;
        food = f;
    }

    public Food item() {
        return food;
    }

    public Customer getCustomer() {
        return customer;
    }

    public WaitPerson getWaitPerson() {
        return waitPerson;
    }

    @Override public String toString() {
        return "Order: " + id + " item: " + food + " served by: " + waitPerson;
    }
}
