package play.proxy.dynamic;

/**
 * @author will
 * @date 2019/3/8
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("==============RealSubject Request=============");
    }
}
