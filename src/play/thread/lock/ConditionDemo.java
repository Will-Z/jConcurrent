package play.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author will
 * @date 2019/2/28
 */
public class ConditionDemo {
    static Lock lock = new ReentrantLock();
    static Condition condi = lock.newCondition();

    public static void main(String[] args) throws InterruptedException{
        Runnable r = () -> {
            try {
                lock.lock();
                condi.await();
                System.out.println("Thread is going on");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        };

        new Thread(r).start();
        System.out.println("Thread is start");
        Thread.sleep(1000);
        lock.lock();
        condi.signal();
        lock.unlock();
    }

}
