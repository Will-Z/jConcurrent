package thinkInJava.concurrent.two.fourteen.caught;

/**
 * @author Will
 * @date 2018/7/19.
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught " + e);
    }
}
