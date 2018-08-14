package thinkInJava.classinfo.nine.struggle;

import thinkInJava.classinfo.nine.iv.A;
import thinkInJava.classinfo.nine.outpk.HiddenImplementation;

/**
 * 匿名类对反射 仍旧没有隐藏任何东西
 *
 * @author Will
 * @date 2018/8/14.
 */
public class AnonymousImplementation {
    public static void main(String[] args) throws Exception {
        A a = AnonymousA.makeA();
        a.f();
        System.out.println(a.getClass().getName());

        // Reflection still gets into the anonymous class
        HiddenImplementation.callHiddenMethod(a, "g");
        HiddenImplementation.callHiddenMethod(a, "u");
        HiddenImplementation.callHiddenMethod(a, "v");
        HiddenImplementation.callHiddenMethod(a, "w");

    }
}
