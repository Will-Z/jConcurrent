package thinkInJava.concurrent.eight.one;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Will
 * @date 2018/8/3.
 */
public class BankTellerSimulation {
    static final int MAX_LINE_SIZE = 50;
    static final int ADJUSTMENT_PERIOD = 1000;

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        // if line is too long, customers will leave;
        CustomerLine customers = new CustomerLine(MAX_LINE_SIZE);
        exec.execute(new CustomerGenerator(customers));

        // manager will add and remove tellers as necessary
        exec.execute(new TellerManager(exec, customers, ADJUSTMENT_PERIOD));

        System.out.println("Press 'Enter' to quit");
        System.in.read();

        exec.shutdownNow();
    }

}


