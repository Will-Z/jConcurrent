package concuPrac.c8.cc4;

import java.util.concurrent.ThreadFactory;

/**
 *
 * 自定义线程工厂
 *
 * @author Will
 * @date 2018/9/17.
 */
public class MyThreadFactory implements ThreadFactory {
    private final String poolName;

    public MyThreadFactory(String poolName) {
        this.poolName = poolName;
    }

    @Override public Thread newThread(Runnable r) {
        return new Thread(r, poolName);
    }
}
