package play.thread.synchronization;

import java.util.Random;

/**
 * @author will
 * @date 2019/2/22
 */
public class Count {
    static int count = 0;

    static void countNum() {
        for (int i = 0; i < 100; i ++) {
            count++;
            Thread.yield();
        }
    }

    static void other() {
        Random rand = new Random(47);
        var x = 0;
        x += rand.nextInt(100);
        System.out.println(Thread.currentThread().getName() + ": " + x);
    }

    public static void main(String[] args) throws InterruptedException {
        var t1 = new Thread(Count::countNum);
        var t2 = new Thread(Count::other);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(Thread.currentThread().getName() + ": " + count);

//        Random rand = new Random(47);
//        for (var i = 0; i < 10; i++) {
//            System.out.println(rand.nextInt(10));
//        }



    }
}
