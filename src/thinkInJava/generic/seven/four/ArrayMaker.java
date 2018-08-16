package thinkInJava.generic.seven.four;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Will
 * @date 2018/8/16.
 */
public class ArrayMaker<T> {
    private Class<T> kind;

    public ArrayMaker(Class<T> kind) {
        this.kind = kind;
    }

    T[] create(int size) {
        return (T[])Array.newInstance(kind, size);
    }

    void p() {
        System.out.println(kind);
    }

    public static void main(String[] args) {
        ArrayMaker<String> stringMaker = new ArrayMaker<>(String.class);
        String[] stringArray = stringMaker.create(9);

        System.out.println(Arrays.toString(stringArray));
    }
}
