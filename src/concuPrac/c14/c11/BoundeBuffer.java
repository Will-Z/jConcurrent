package concuPrac.c14.c11;

/**
 * 使用条件队列实现有界缓存
 *
 * @author Will
 * @date 2018/9/21.
 */
public class BoundeBuffer<V> extends BaseBoundedBuffer<V> {

    public BoundeBuffer(int size) {
        super(size);
    }

    public synchronized void put(V v) throws InterruptedException {
        while (isFull()) {
            wait();
        }
        doPut(v);
        notifyAll();
    }

    public synchronized V take() throws InterruptedException {
        while(isEmpty()) {
            wait();
        }
        V v = doTake();
        notifyAll();
        return v;
    }
}
