package thinkInJava.generic.four.four.test;

/**
 * @author Will
 * @date 2018/8/15.
 */
public class CountedObject {
    private static long counter = 0;
    private final long id = counter++;

    public long id() {
        return id;
    }

    @Override public String toString() {
        return "CountedObject  " + id;
    }
}
