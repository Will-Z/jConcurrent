package thinkInJava.classinfo.seven.dynamic;

import thinkInJava.classinfo.seven.Interface;
import thinkInJava.classinfo.seven.RealObject;

import java.lang.reflect.Proxy;

/**
 * @author Will
 * @date 2018/8/13.
 */
public class SimpleDynamicProxy {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("fafafafa");
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);

        // insert a proxy and call again;
        Interface proxy = (Interface)Proxy.newProxyInstance(
            Interface.class.getClassLoader(),
            new Class[]{Interface.class},
            new DynamicProxyHandler(real)
        );

        consumer(proxy);
    }
}
