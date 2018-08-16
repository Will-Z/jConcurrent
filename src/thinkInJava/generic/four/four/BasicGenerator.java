package thinkInJava.generic.four.four;

import thinkInJava.generic.three.coff.Generator;

/**
 * a general generator
 *
 * @author Will
 * @date 2018/8/15.
 */
public class BasicGenerator<T> implements Generator<T>{
    private Class<T> type;

    public BasicGenerator(Class<T> type) {
        this.type = type;
    }

    @Override public T next() {
        try {
            return type.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T>  Generator<T> create(Class<T> type) {
        return new BasicGenerator<>(type);
    }
}
