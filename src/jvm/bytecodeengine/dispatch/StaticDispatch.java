package jvm.bytecodeengine.dispatch;

/**
 * 方法静态分派演示

 * @author Will
 * @date 2018/8/30.
 */
public class StaticDispatch {
    static abstract class Human {
    }

    static class Man extends Human {
    }

    static class Woman extends Human {
    }

    public void sayHello(Human guy) {
        System.out.println("hello, guy");
    }

    public void sayHello(Man guy) {
        System.out.println("hello gentleman");
    }

    public void sayHello(Woman guy) {
        System.out.println("hello lady");
    }

    public static void main(String[] args) {
        // "Human"称为变量的静态类型(Static Type) 或者 叫做外观类型(Apparent Type)
        // 后面的 "Man"称为变量的实际类型(Actual Type)
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch sr = new StaticDispatch();
        sr.sayHello(man);
        sr.sayHello(woman);
    }
}
