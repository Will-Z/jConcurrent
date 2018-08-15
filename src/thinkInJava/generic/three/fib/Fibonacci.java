package thinkInJava.generic.three.fib;

import thinkInJava.generic.three.coff.Generator;

/**
 * @author Will
 * @date 2018/8/14.
 */
public class Fibonacci implements Generator<Integer> {
    private int count;

    private int fib (int x) {
        if (x < 2) {
            return 1;
        }
        return fib(x -1 ) + fib(x - 2);
    }

    @Override public Integer next() {
        return fib(count++);
    }

    public static void main(String[] args) {
        Fibonacci gen = new Fibonacci();

        for (int i = 0; i < 20; i++) {
            System.out.print(gen.next() + " ");
        }
    }
}
