package thinkInJava.concurrent.eight.one;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Teach the customer line to display itself
 *
 * @author Will
 * @date 2018/8/3.
 */
public class CustomerLine extends ArrayBlockingQueue<Customer> {
    public CustomerLine(int maxLineSize) {
        super(maxLineSize);
    }

    @Override public String toString() {
        if(this.size() == 0) {
            return "[Empty]";
        }
        StringBuilder result = new StringBuilder();
        for (Customer customer : this) {
            result.append(customer);
        }
        return result.toString();
    }
}
