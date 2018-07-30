package thinkInJava.concurrent.three.one;

/**
 * @author Will
 * @date 2018/7/19.
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;

    public abstract int next();

    public void cancel() {
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }
}
