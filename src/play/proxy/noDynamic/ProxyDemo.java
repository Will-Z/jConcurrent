package play.proxy.noDynamic;

/**
 * @author will
 * @date 2019/3/8
 */
public class ProxyDemo {
    public static void main(String[] args) {
        RealSubject subject = new RealSubject();
        Proxy p = new Proxy(subject);
        p.request();
    }
}
