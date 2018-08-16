package thinkInJava.generic.seven.four;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Will
 * @date 2018/8/16.
 */
public class ListMaker<T> {
    List<T> create() {
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        ListMaker<String> stringMaker = new ListMaker<String>();
        List<String> stringList = stringMaker.create();
    }
}
