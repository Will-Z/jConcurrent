package thinkInJava.generic.ten;

import java.util.ArrayList;
import java.util.List;

/**
 *  <? extends Fruit> 上界 不能往里存, 只能往外取;
 *  读出来的东西 只能放在 Fruit 或者它的基类里
 *
 *
 * @author Will
 * @date 2018/8/17.
 */
public class GenericAndCovariance {
    public static void main(String[] args) {
        List<? extends Fruit> flist = new ArrayList<Apple>();

//        flist.add(new Fruit());
//        flist.add(new Apple());

        flist.add(null);

        Fruit f = flist.get(0);
    }
}
