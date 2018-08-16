package thinkInJava.generic.eight.one.tem;

/**
 * @author Will
 * @date 2018/8/16.
 */
public class Creator extends GenericWithCreate<X> {
    @Override X create() {
        return new X();
    }

    void f() {
        System.out.println(element.getClass().getSimpleName());
    }
}
