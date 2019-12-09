package concuPrac;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * p.s. 线程被唤醒后会尝试重新获得与之绑定的锁, 所以signal之后要注意释放锁让给被唤醒线程;
 *
 * @author will
 * @date 2019/12/9
 */
public class SimpleConditionDemo {
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        Runnable r  = () -> {
            try {
                lock.lock();
                System.out.println("thread is waiting");
                condition.await();
                System.out.println("thread is going on");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        };
        new Thread(r).start();
        Thread.sleep(2000);
        lock.lock();
        condition.signal();
        lock.unlock();

    }
}
