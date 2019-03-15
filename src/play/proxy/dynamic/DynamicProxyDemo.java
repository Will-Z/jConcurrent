package play.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * @author will
 * @date 2019/3/8
 */
public class DynamicProxyDemo {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        ProxyHandler handler = new ProxyHandler(realSubject);
        Subject proxySubject = (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(),
                                                            RealSubject.class.getInterfaces(), handler);
        proxySubject.request();
    }
}
