package play.thread.synchronization;

/**
 * 两个线程交替输出奇数偶数
 *
 * 使用 对象monitor的 wait notify 实现
 *
 * @author will
 * @date 2019/2/14
 */
public class NumberGenerate {

    static final Integer TOTAL = 10;
    static Object oddLock = new Object();
    static Object evenLock = new Object();
    static int nextState = 1;

    static void printOdd() {
        var oddNum = 1;
        while (oddNum <= TOTAL) {
            while (nextState == 0) {
                synchronized (oddLock) {
                    try {
                        oddLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(oddNum);
            oddNum += 2;
            nextState = 0;
            synchronized (evenLock) {
                evenLock.notify();
            }
        }
    }

    static void printEven() {
        var evenNum = 2;
        while (evenNum <= TOTAL) {
            while (nextState == 1) {
                synchronized (evenLock) {
                    try {
                        evenLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(evenNum);
            evenNum += 2;
            nextState = 1;
            synchronized (oddLock) {
                oddLock.notify();
            }

        }

    }

    static void start() throws InterruptedException{
        var odd = new Thread(NumberGenerate::printOdd);
        var even = new Thread(NumberGenerate::printEven);

        odd.start();
        even.start();
        odd.join();
        even.join();
    }

    public static void main(String[] args) throws InterruptedException {

        start();
    }




}
