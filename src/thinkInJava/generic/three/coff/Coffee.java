package thinkInJava.generic.three.coff;

/**
 * @author Will
 * @date 2018/8/14.
 */
public class Coffee {
    private static long counter = 0;
    private final long id = counter++;

    @Override public String toString() {
        return getClass().getSimpleName() + "  " +id;
    }
}
