package concuPrac.c14.cc3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Will
 * @date 2018/9/21.
 */
public class ConditionBoundedBuffer<T> {
    private static final int BUFFER_SIZE = 100;
    protected final Lock lock = new ReentrantLock();

    // 条件谓词: notFull (count < items.length)
    private final Condition notFull = lock.newCondition();

    //条件谓词: notEmpty (count > 0)
    private final Condition notEmpty = lock.newCondition();

    private final T[] items = (T[]) new Object[BUFFER_SIZE];
    private int tail, head, count;

    public void put(T x) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length) {
                notFull.await();
            }
            items[tail] = x;
            if (++tail == items.length) {
                tail = 0;
            }
            count++;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public T take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            T ans = items[head];
            items[head] = null;
            if (++head == items.length) {
                head = 0;
            }
            count--;
            notFull.signal();
            return  ans;
        } finally {
            lock.unlock();
        }
    }
}
