package thinkInJava.classinfo.nine.iv;

/**
 * @author Will
 * @date 2018/8/14.
 */
public class InterfaceViolation {
    public static void main(String[] args) {
        A a = new B();
        a.f();

//        a.g();   // Compile error

        System.out.println(a.getClass().getName());
        if (a instanceof B) {
            B b = (B) a;
            b.g();
        }
    }
}
