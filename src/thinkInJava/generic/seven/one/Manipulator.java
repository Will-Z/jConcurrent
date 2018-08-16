package thinkInJava.generic.seven.one;

/**
 * @author Will
 * @date 2018/8/16.
 */
public class Manipulator<T> {
    private T obj;

    public Manipulator(T x) {
        obj = x;
    }

    public void manipulate() {

        // 因为Java 泛型的类型擦除, 此处编译不通过 因为无法得知obj的具体类型 不知道是否有f()方法
        // 类似的代码 在c++中可以正常工作
//        obj.f();
    }
}
