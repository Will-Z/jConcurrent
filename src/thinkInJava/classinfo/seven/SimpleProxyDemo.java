package thinkInJava.classinfo.seven;

/**
 * @author Will
 * @date 2018/8/13.
 */
public class SimpleProxyDemo {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("hehe");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}
