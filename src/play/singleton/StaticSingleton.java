package play.singleton;

/**
 * 最优的单例
 *
 * getInstance()方法中没有锁, 高并发下性能优越;
 * 且能够实现延迟加载
 *
 * @author will
 * @date 2019/8/29
 */
public class StaticSingleton {
    private StaticSingleton() {}

    private static class SingletonHolder {
        private static StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance() {
        return SingletonHolder.instance;
    }
}
