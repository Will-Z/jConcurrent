package thinkInJava.classinfo.two.two;

/**
 * @author Will
 * @date 2018/8/8.
 */
public class CountedInteger {
    private static long counter;
    private final long id = counter++;

    @Override public String toString() {
        return Long.toString(id);
    }
}
