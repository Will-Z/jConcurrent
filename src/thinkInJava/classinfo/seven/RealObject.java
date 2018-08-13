package thinkInJava.classinfo.seven;

/**
 * @author Will
 * @date 2018/8/13.
 */
public class RealObject implements Interface {

    @Override public void doSomething() {
        System.out.println("doSomething");
    }

    @Override public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);

    }
}
