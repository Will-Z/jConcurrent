package thinkInJava.generic.eight.one;

/**
 * @author Will
 * @date 2018/8/16.
 */
public class ClassAsFactory<T> {
    T x;

    public ClassAsFactory(Class<T> kind) {
        try {
            x = kind.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
