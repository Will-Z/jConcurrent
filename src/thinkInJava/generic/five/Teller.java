package thinkInJava.generic.five;

import thinkInJava.generic.three.coff.Generator;

/**
 * @author Will
 * @date 2018/8/15.
 */
public class Teller {
    private static long counter = 1;
    private final long id = counter++;

    private Teller() {}

    @Override public String toString() {
        return "Teller  " + id;
    }

    public static Generator<Teller> generator =
        new Generator<Teller>() {
            @Override public Teller next() {
                return new Teller();
            }
        };
}
