package thinkInJava.concurrent.three.one;

/**
 * 没有锁定机制,  当某任务执行到标记(danger)处时, 另外的任务可能会调用next方法,  从而产生奇数
 *
 * @author Will
 * @date 2018/7/19.
 */
public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    @Override public int next() {
        ++currentEvenValue;   // danger point here
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
