package play.thread.synchronization;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static java.lang.Thread.currentThread;

/**
 * 两个线程交替输出奇偶
 *
 * BlockingArray实现
 * @author will
 * @date 2019/2/21
 */
public class NumberGenerator3 {
    static final int TOTAL = 10;
    static BlockingQueue<Object> oddQueue = new ArrayBlockingQueue<>(1);
    static BlockingQueue<Object> evenQueue = new ArrayBlockingQueue<>(1);

//    public NumberGeneratorw3() throws InterruptedException {
//        oddQueue.put(new Object());
//    }

    static void printOdd() {
        var oddNum = 1;
        while (oddNum <= TOTAL) {
            try {
                oddQueue.take();
                System.out.println(currentThread().getName() + ": " + oddNum);
                oddNum += 2;
                evenQueue.put(new Object());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static void printEven() {
        var evenNum = 2;
        while (evenNum <= TOTAL) {
            try {
                evenQueue.take();
                System.out.println(currentThread().getName() + ": " +  evenNum);
                evenNum += 2;
                oddQueue.put(new Object());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static void start() throws Exception {
        var odd = new Thread(NumberGenerator3::printOdd);
        var even = new Thread(NumberGenerator3::printEven);
        odd.start();
        even.start();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(currentThread().getName() + ": " +  new NumberGenerator3().getClass().getSimpleName());
        oddQueue.put(new Object());

        start();
    }


}
