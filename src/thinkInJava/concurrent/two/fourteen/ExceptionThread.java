package thinkInJava.concurrent.two.fourteen;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * 线程中的异常 不会传播回主线程
 *
 * @author Will
 * @date 2018/7/19.
 */
public class ExceptionThread implements Runnable {

    @Override public void run() {
        throw new RuntimeException();
    }
    public static void main(String[] args) {
        try {
            ExecutorService exec = Executors.newCachedThreadPool();
            exec.execute(new ExceptionThread());
        } catch(RuntimeException e) {
            System.out.println("Exeception has been handled!");
        }
    }
}
