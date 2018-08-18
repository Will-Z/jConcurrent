package thinkInJava.generic.twelve.one;

/**
 * @author Will
 * @date 2018/8/17.
 */
public class BasicHolder<T> {
    T element;

    public void set(T element) {
        this.element = element;
    }

    public T get() {
        return element;
    }

    public void f() {
        System.out.println(element.getClass().getSimpleName());
    }
}
