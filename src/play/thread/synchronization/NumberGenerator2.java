package play.thread.synchronization;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程交替输出奇数偶数
 *
 * 使用 condition的 await signal 实现
 *
 * @author will
 * @date 2019/2/21
 */
public class NumberGenerator2 {
    static final int TOTAL = 10;

    static ReentrantLock lock = new ReentrantLock();
    static Condition oddCon = lock.newCondition();
    static Condition evenCon = lock.newCondition();
    static int nextState = 1;


    static void printOdd() {
        var oddNum = 1;
        while (oddNum <= TOTAL) {
                try {
                    lock.lock();
                    while (nextState == 0) {
                        oddCon.await();
                    }
                    System.out.println(oddNum);
                    oddNum += 2;
                    nextState = 0;
                    evenCon.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }




        }
    }

    static void printEven() {
        var evenNum = 2;
        while (evenNum <= TOTAL) {
                try {
                    lock.lock();
                    while (nextState == 1) {
                        evenCon.await();
                    }
                    System.out.println(evenNum);
                    evenNum += 2;
                    nextState = 1;
                    oddCon.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }


        }
    }

    static void start() throws InterruptedException {
        var odd = new Thread(NumberGenerator2::printOdd);
        var even = new Thread(NumberGenerator2::printEven);
        odd.start();
        even.start();
        odd.join();
        even.join();
    }

    public static void main(String[] args) throws Exception{
        start();
    }


}
