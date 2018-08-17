package thinkInJava.generic.twelve.one;

/**
 * @author Will
 * @date 2018/8/17.
 */
public class BasicHolder<T> {
    T element;

    void set(T element) {
        this.element = element;
    }

    T get() {
        return element;
    }

    void f() {
        System.out.println(element.getClass().getSimpleName());
    }
}
