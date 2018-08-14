package thinkInJava.classinfo.nine.struggle.modify;

/**
 * @author Will
 * @date 2018/8/14.
 */
public class WithPrivateFinalField {
    private int i = 1;

    private final String s = "I'm totally safe";

    private String s2 = "Am I safe?";

    @Override public String toString() {
        return "i = " + i + ", " + s + ", " + s2;
    }
}
