package play.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author will
 * @date 2019/3/8
 */
public class ProxyHandler implements InvocationHandler {
    private Subject subject;
    public ProxyHandler(Subject subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("=========before======");
        Object result = method.invoke(subject, args);
        System.out.println("=========after======");
        return result;
    }
}
