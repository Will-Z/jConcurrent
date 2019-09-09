package play.singleton;

/**
 * 最简单的单例模式
 * 优点: 简单
 * 缺点: Singleton实例的创建时间是不受控制的; 如 在任何地方引用这个STATUS都会导致instance被创建
 *
 * @author will
 * @date 2019/8/29
 */
public class Singleton {
    public static int STATUS = 1;

    private Singleton() {}

    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }

}
