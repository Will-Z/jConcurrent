package thinkInJava.concurrent.three.three.atom;

/**
 * p.s. 因为 nextSerialNumber() 不是线程安全的, 所以 SerialNumberChecker main 运行会产生 Duplicate xxx
 *
 * nextSerialNumber 应该加  synchronized 关键字
 *
 * @author Will
 * @date 2018/7/20.
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    public static  int nextSerialNumber() {
        // not thread-safe
        return serialNumber++;
    }
}
