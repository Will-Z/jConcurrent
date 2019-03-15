package play.steam;

import util.PrimeUtil;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author will
 * @date 2019/3/11
 */
public class ParallelStream {
    public static void main(String[] args) {

        long before = System.currentTimeMillis();
        // 串行
        long res0 = IntStream.range(1,1000000).filter(PrimeUtil::isPrime).count();
        System.out.println("res0  " + res0 + "   " + (System.currentTimeMillis() - before));

        before = System.currentTimeMillis();
        // 并行
        long res1 = IntStream.range(1,1000000).parallel().filter(PrimeUtil::isPrime).count();
        System.out.println("res0  " + res0 + "   " + (System.currentTimeMillis() - before));



        int[] a = {3,2,5,3,1,7,3,11,2,108};
        // 并行排序
        Arrays.parallelSort(a);
        Arrays.stream(a).forEach(System.out::println);


        System.out.println();

        Random r = new Random();
        // 串行
        Arrays.setAll(a, (i) -> r.nextInt(100));
        Arrays.stream(a).forEach(System.out::println);

        System.out.println();

        //并行
        Arrays.setAll(a, (i) -> r.nextInt(100));
        Arrays.stream(a).forEach(System.out::println);



    }
}
