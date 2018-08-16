package thinkInJava.generic.seven.one;

/**
 * @author Will
 * @date 2018/8/16.
 */
public class Manipulator2<T extends HasF> {
    private T obj;

    public Manipulator2(T x) {
        obj = x;
    }

    public void manipulate() {
        obj.f();
    }
}
