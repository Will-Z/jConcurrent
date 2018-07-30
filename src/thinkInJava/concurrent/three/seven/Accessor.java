package thinkInJava.concurrent.three.seven;

/**
 * @author Will
 * @date 2018/7/20.
 */
public class Accessor implements Runnable {
    private int id;

    public Accessor(int id) {
        this.id = id;
    }

    @Override public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            ThreadLocalVariableHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }

    @Override public String toString() {
        return "#" + id + ": " + ThreadLocalVariableHolder.get();
    }
}
