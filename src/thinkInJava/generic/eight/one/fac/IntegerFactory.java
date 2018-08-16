package thinkInJava.generic.eight.one.fac;

/**
 * @author Will
 * @date 2018/8/16.
 */
public class IntegerFactory implements FactoryI<Integer> {
    @Override public Integer create() {
        return new Integer(0);
    }
}
