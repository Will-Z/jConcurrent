package thinkInJava.concurrent.two.fourteen.caught;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Will
 * @date 2018/7/19.
 */
public class CaptureUncaughtException {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread2());
    }
}
