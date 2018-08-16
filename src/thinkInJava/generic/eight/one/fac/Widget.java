package thinkInJava.generic.eight.one.fac;

/**
 * @author Will
 * @date 2018/8/16.
 */
public class Widget {
    public static class Factory implements FactoryI<Widget> {
        @Override public Widget create() {
            return new Widget();
        }
    }
}
