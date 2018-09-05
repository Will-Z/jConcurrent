package concuPrac.c3.cc1;

/**
 * [F] 虽然NoVisibility看起来会输出42, 但事实上很可能输出0, 或者根本无法终止.
 *  因为代码中没有足够的同步机制, 因此无法保证主线程写入的ready和number对于读线程是可见的;
 *
 * p.s. 我尝试的几次(包括 for循环100此) 都是能正常输出的,
 *      不排除是并发中的巧合 或者是jvm有特殊的优化
 *
 *
 *
 * @author Will
 * @date 2018/9/5.
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread implements Runnable {
        @Override public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {

        new Thread(new ReaderThread()).start();

        number = 42;
        ready = true;

    }
}
