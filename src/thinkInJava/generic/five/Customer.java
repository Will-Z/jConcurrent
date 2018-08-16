package thinkInJava.generic.five;

import thinkInJava.generic.three.coff.Generator;

/**
 * @author Will
 * @date 2018/8/15.
 */
public class Customer {
    private static long counter = 1;
    private final long id = counter++;

    private Customer() {}

    @Override public String toString() {
        return "Customer  " + id;
    }

    public static Generator<Customer> generator() {
        return new Generator<Customer>() {
            @Override public Customer next() {
                return new Customer();
            }
        };
    }
}
