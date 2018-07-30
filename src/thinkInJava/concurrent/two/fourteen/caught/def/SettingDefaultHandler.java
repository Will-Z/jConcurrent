package thinkInJava.concurrent.two.fourteen.caught.def;

import thinkInJava.concurrent.two.fourteen.ExceptionThread;
import thinkInJava.concurrent.two.fourteen.caught.MyUncaughtExceptionHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Will
 * @date 2018/7/19.
 */
public class SettingDefaultHandler {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
    }
}
