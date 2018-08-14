package thinkInJava.classinfo.nine.struggle;

import thinkInJava.classinfo.nine.iv.A;

/**
 *  将接口实例化为匿名类的对象  妄图使反射不能触及(然而 并不可能)
 *
 * @author Will
 * @date 2018/8/14.
 */
public class AnonymousA {
    public static A makeA() {
        return new A() {

            @Override public void f() {
                System.out.println("public C.f()");
            }

            public void g() {
                System.out.println("public C.g()");
            }

            void u() {
                System.out.println("package C.u()");
            }

            protected void v() {
                System.out.println("protected C.v()");
            }

            private void w() {
                System.out.println("private C.w()");
            }

        };
    }
}
