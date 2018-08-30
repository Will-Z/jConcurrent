package jvm.bytecodeengine;

import java.lang.invoke.MethodType;

/**
 * @author Will
 * @date 2018/8/29.
 */
public class MethodHandleTest {
    static class ClassA {
        public void println(String s) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) throws Throwable {
        Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();
        MethodType mt = MethodType.methodType(void.class, String.class);

//        return lookup().findVirtual (reveiver.getClass(), "println", mt).bindTo(reveiver);
    }

        
}
