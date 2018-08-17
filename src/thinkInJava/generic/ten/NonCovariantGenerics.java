package thinkInJava.generic.ten;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Will
 * @date 2018/8/17.
 */
public class NonCovariantGenerics {

    /*
     *  编译报错
     */
    //    List<Fruit> fList = new ArrayList<Apple>();


    public static void main(String[] args) {
        List<Fruit> fList = new ArrayList<>();

        fList.add(new Fruit());
        fList.add(new Apple());
        fList.add(new Orange());
        fList.add(new Jonathan());

        for (Fruit f : fList) {
            System.out.println(f.getClass());
        }
    }


}
