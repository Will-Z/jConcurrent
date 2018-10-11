package concuArt.c6;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Fork/Join框架的使用
 *
 * p.s.  这种算法 的写法让我想到了快排
 *
 * @author Will
 * @date 2018/10/10.
 */
public class CountTask extends RecursiveTask<Integer>  {
    // 阈值
    private static final int THRESHOLD = 2;
    private int start, end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override protected Integer compute() {
        int sum = 0;

        // 如果任务足够小就计算
        boolean canCompute = (end - start) <= THRESHOLD;

        if (canCompute) {
            for (int i = start; i <=end; i++) {
                sum += i;
            }
        } else {
            // 如果任务大于阈值, 就分裂成两个子任务
            int mid = (start + end) >> 1;
            CountTask leftTask = new CountTask(start, mid);
            CountTask rightTask = new CountTask(mid + 1, end);

            leftTask.fork();
            rightTask.fork();

            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        // 生成一个计算任务, 负责计算 1+2+3+4
        CountTask task = new CountTask(1, 4);

        // 执行一个任务
        Future<Integer> result = forkJoinPool.submit(task);
        try {
            System.out.println(result.get());
        } catch (Exception e) {
            // ignore
        }
    }
}
