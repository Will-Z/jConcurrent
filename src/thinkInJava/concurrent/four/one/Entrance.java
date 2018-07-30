package thinkInJava.concurrent.four.one;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Will
 * @date 2018/7/30.
 */
public class Entrance implements  Runnable {
    private static Count count = new Count();
    private static List<Entrance> entrances = new ArrayList<>();
    private int number = 0;

    private int id;

    private static volatile boolean canceled = false;

    // Atomic operation on a volatile field
    public static void cancel() {
        canceled = true;
    }

    public Entrance(int id) {
        this.id = id;

        // keep this task in a list.
        // Also prevents garbage collection of dead tasks
        entrances.add(this);
    }

    public synchronized int getValue() {
        return number;
    }

    @Override public String toString() {
        return "Entrance " + id + ": " + getValue();
    }

    public static int getTotalCount() {
        return count.value();
    }

    public static int sumEntrances() {
        int sum = 0;
        for (Entrance entrance : entrances) {
            sum += entrance.getValue();
        }
        return sum;
    }


    @Override public void run() {
        while (!canceled) {
            synchronized (this) {
                ++number;
            }
            System.out.println(this + " Total: " + count.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("sleep interrupted");
            }
        }
        System.out.println("Stopping " + this);
    }
}
