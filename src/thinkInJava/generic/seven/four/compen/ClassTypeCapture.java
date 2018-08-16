package thinkInJava.generic.seven.four.compen;

/**
 * 用 类型标签 对擦除进行补偿
 *
 * @author Will
 * @date 2018/8/16.
 */
public class ClassTypeCapture<T> {
    Class<T> kind;

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public static void main(String[] args) {
        ClassTypeCapture<Building> ct1 = new ClassTypeCapture<>(Building.class);
        System.out.println(ct1.f(new Building()));
        System.out.println(ct1.f(new House()));

        ClassTypeCapture<House> ct2 = new ClassTypeCapture<>(House.class);
        System.out.println(ct2.f(new Building()));
        System.out.println(ct2.f(new House()));
    }
}
