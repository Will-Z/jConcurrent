package thinkInJava.generic.ten;

/**
 * @author Will
 * @date 2018/8/17.
 */
public class CovariantArrays {
    public static void main(String[] args) {

        Fruit[] fruit = new Apple[10];
        fruit[0] = new Apple();      //ok
        fruit[0] = new Jonathan();   //ok

        /*
         * fruit 的运行时类型是 Apple 而不是Fruit
         */

        try {
            // 可以通过编译
            fruit[0] = new Fruit();     // ArrayStoreException
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            // 可以通过编译
            fruit[0] = new Orange();      //ArrayStoreException
        } catch (Exception e) {
            System.out.println(e);
        }


        System.out.println(fruit.getClass());
    }
}
