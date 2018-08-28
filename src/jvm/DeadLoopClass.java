package jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 如果多个线程同时初始化一个类, 只有一个线程会去执行这个类的<clinit>()方法, 其他线程都需要阻塞等待;
 *
 * p.s.  需要注意的是, 其他线程虽然会被阻塞, 但如果执行<clinit>()方法的那条线程 退出 <clinit>()方法后,
 *       其他线程唤醒之后不会再次进入<clinit>()方法. 同一个类加载器下, 一个类型只会初始化一次;
 *
 *
 * @author Will
 * @date 2018/8/28.
 */
public class DeadLoopClass {
    static {
        if (true) {
            System.out.println(Thread.currentThread() + "init DeadLooplass");

            int bigNum = 10000000;
            Random rand = new Random(17);
            List<Integer> s = new ArrayList<>();

            for (int i = 0; i < bigNum; i++) {
                s.add(rand.nextInt());
            }

            System.out.println("init over");
        }
    }

    public static void main(String[] args) {
        Runnable script = new Runnable() {
            @Override public void run() {
                System.out.println(Thread.currentThread() + "   start");
                DeadLoopClass dlc = new DeadLoopClass();
                System.out.println(Thread.currentThread() + "   run over");
            }
        };

        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(script);
        exec.execute(script);

        try {
            TimeUnit.MILLISECONDS.sleep(3000);
            exec.shutdown();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
