package play.singleton;


/**
 *
 * Double Check Lock 单例
 *
 * 优点: 延迟加载 线程安全
 * 缺点: 不优雅 我不喜欢这么写
 *
 * @author will
 * @date 2019/9/23
 */
public class DclSingleton {
    private DclSingleton() {}

    private volatile static DclSingleton instance;

    public static DclSingleton getInstance() {
        if (instance == null) {
            synchronized (DclSingleton.class) {
                if (instance == null) {
                    instance = new DclSingleton();
                }
            }
        }
        return instance;
    }
}
