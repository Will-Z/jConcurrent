package thinkInJava.concurrent.eight.one;

/**
 * Read-only objects don't require synchronization
 *
 * @author Will
 * @date 2018/8/3.
 */
public class Customer {
    private int serviceTime;

    public Customer(int tm) {
        serviceTime = tm;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    @Override public String toString() {
        return "[" + serviceTime + "]";
    }
}
