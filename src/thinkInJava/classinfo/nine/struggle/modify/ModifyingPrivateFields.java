package thinkInJava.classinfo.nine.struggle.modify;

import java.lang.reflect.Field;

/**
 *
 * final域在遭遇修改是依然是安全的;  运行时系统会在不抛异常的情况下接收任何修改尝试, 但是实际上不会发生任何修改
 *
 * @author Will
 * @date 2018/8/14.
 */
public class ModifyingPrivateFields {
    public static void main(String[] args) throws Exception {
        WithPrivateFinalField pf = new WithPrivateFinalField();
        System.out.println("1   " + pf);                                               // 1

        Field f = pf.getClass().getDeclaredField("i");
        f.setAccessible(true);
        System.out.println("2   f.getInt(pf): " + f.getInt(pf));                       // 2

        f.setInt(pf, 47);
        System.out.println("3   " + pf);                                               // 3

        f = pf.getClass().getDeclaredField("s");
        f.setAccessible(true);
        System.out.println("4    f.get(pf): " + f.get(pf));                            // 4

        f.set(pf, "No you're not!");
        System.out.println("5   " + pf);                                                // 5

        f = pf.getClass().getDeclaredField("s2");
        f.setAccessible(true);
        System.out.println("6   f.get(pf) " + f.get(pf));                               // 6

        f.set(pf, "No, you're not!");
        System.out.println("7   " + pf);




    }
}
