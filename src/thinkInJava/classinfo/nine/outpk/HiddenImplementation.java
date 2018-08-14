package thinkInJava.classinfo.nine.outpk;

import thinkInJava.classinfo.nine.inpk.HiddenC;
import thinkInJava.classinfo.nine.iv.A;

import java.lang.reflect.Method;

/**
 * @author Will
 * @date 2018/8/14.
 */
public class HiddenImplementation {
    public static void main(String[] args) throws Exception {
        A a = HiddenC.makeA();
        a.f();
        System.out.println(a.getClass().getName());

        // 因为C只在包内可访问; 所以此处'compile error: cannot find symbol C'
        // 所以无法像 /iv/InterfaceViolation 中那样做向下转型
        /*
        if (a instanceof C) {
            C c = (C)a;
            c.g();
        }
        */


        // Oops! Reflection still allows us to call g()
        callHiddenMethod(a, "g");

        // And even methods that are less accessible
        callHiddenMethod(a, "u");
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");


    }

    public static void callHiddenMethod(Object a, String methodName) throws Exception {
        Method g = a.getClass().getDeclaredMethod(methodName);
        g.setAccessible(true);
        g.invoke(a);
    }
}
