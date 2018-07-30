package thinkInJava.concurrent.two.eleven;

/**
 * @author Will
 * @date 2018/7/18.
 */
public class Joiner extends Thread {
    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override public void run() {
        try {
            sleeper.join();
        } catch(InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println(getName() + " join completed");

    }
}
