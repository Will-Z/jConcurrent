package thinkInJava.generic.eight.one.fac;

/**
 * @author Will
 * @date 2018/8/16.
 */
public class Foo2<T> {
    private T x;
    public <F extends FactoryI<T>> Foo2(F factory){
        x = factory.create();
    }
}
