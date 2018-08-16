package thinkInJava.generic.eight.one.tem;

/**
 * @author Will
 * @date 2018/8/16.
 */
public abstract class GenericWithCreate<T> {
    T element;

    abstract T create();

    GenericWithCreate() {
        element = create();
    }
}
