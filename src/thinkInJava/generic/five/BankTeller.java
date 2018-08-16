package thinkInJava.generic.five;

import java.util.*;

/**
 * @author Will
 * @date 2018/8/15.
 */
public class BankTeller {
    public static void serve(Teller t, Customer c) {
        System.out.println(t + "  serves  " + c);
    }

    public static void main(String[] args) {
        Random rand = new Random(47);
        Queue<Customer> line = new LinkedList<>();

        for (int i = 0; i < 15; i++) {
            line.add(Customer.generator().next());
        }

        List<Teller> tellers = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            tellers.add(Teller.generator.next());
        }

        for (Customer c : line) {
            serve(tellers.get(rand.nextInt(tellers.size())), c);
        }

    }

}
