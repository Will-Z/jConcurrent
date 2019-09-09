package play.singleton;

/**
 * 优点: 延迟加载, 只有在调用getInstance()时才创建instance
 * 缺点: 并发环境下加锁, 影响性能
 *
 * @author will
 * @date 2019/8/29
 */
public class LazySingleton {
    private LazySingleton() {}

    private static LazySingleton instance = null;

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
