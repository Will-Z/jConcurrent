package thinkInJava.concurrent.three.six;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 在其他对象上进行同步
 *
 * DualSync.f() 在 this同步
 * g() 有一个在 syncObject上的同步块
 * 两个同步相互独立
 *
 * @author Will
 * @date 2018/7/20.
 */
public class DualSynch {
    private Object syncObject = new Object();

    public synchronized void f() {
        for (int i = 0; i < 5; i++) {
            System.out.println("f()");
            Thread.yield();
        }
    }

    public void g() {
        synchronized(syncObject) {
            for (int i = 0; i < 5; i++) {
                System.out.println("g()");
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        final DualSynch ds = new DualSynch();

//        new Thread(() -> ds.f()).start();

        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(() -> ds.f());

        ds.g();
    }
}
