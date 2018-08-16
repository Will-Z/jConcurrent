package thinkInJava.generic.seven.four;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Will
 * @date 2018/8/16.
 */
public class FilledListMaker<T> {
    List<T> create(T t, int n) {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(t);
        }
        return result;
    }

    public static void main(String[] args) {
        FilledListMaker<String> sm = new FilledListMaker<>();

        List<String> list = sm.create("hello", 7);
        System.out.println(list);
    }
}
