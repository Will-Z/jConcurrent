package play.proxy.noDynamic;

/**
 * @author will
 * @date 2019/3/8
 */
public class Proxy implements Subject {
    private Subject subject;
    public Proxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        System.out.println("preProcess");
        subject.request();
        System.out.println("preProcess");
    }
}
