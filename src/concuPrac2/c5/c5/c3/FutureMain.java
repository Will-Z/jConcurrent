package concuPrac2.c5.c5.c3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author will
 * @date 2019/9/5
 */
public class FutureMain {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<String> future = new FutureTask<String>(new RealData("a"));
        ExecutorService service = Executors.newFixedThreadPool(1);
        service.submit(future);

        System.out.println("submit finished");
        for (int i = 0; i < 10; i++) {
            System.out.println("can do other things here");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
        }
        System.out.println("result: " + future.get());
        service.shutdown();
    }
}
