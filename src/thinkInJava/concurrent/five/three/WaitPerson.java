package thinkInJava.concurrent.five.three;

/**
 * @author Will
 * @date 2018/7/31.
 */
public class WaitPerson implements Runnable {
    private Restaurant restaurant;

    public WaitPerson(Restaurant r) {
        restaurant = r;
    }

    @Override public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal == null) {
                        // for the chef to produce a meal
                        wait();
                    }
                }

                System.out.println("Waitperson got " + restaurant.meal);

                synchronized (restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notifyAll();   // Ready to another
                }
            }
        } catch (InterruptedException e) {
            System.out.println("WaitPerson interrupted");
        }
    }
}
