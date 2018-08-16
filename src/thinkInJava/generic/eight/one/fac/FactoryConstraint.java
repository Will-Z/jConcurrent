package thinkInJava.generic.eight.one.fac;

/**
 * @author Will
 * @date 2018/8/16.
 */
public class FactoryConstraint {
    public static void main(String[] args) {
        new Foo2<Integer>(new IntegerFactory());
        new Foo2<Widget>(new Widget.Factory());
    }
}
