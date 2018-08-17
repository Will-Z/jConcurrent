package thinkInJava.generic.ten.border;

import thinkInJava.generic.ten.Apple;
import thinkInJava.generic.ten.Fruit;

/**
 * @author Will
 * @date 2018/8/17.
 */
public class Holder<T> {
    private T value;

    public Holder() {}

    public Holder(T val) {
        value = val;
    }

    public void set(T val) {
        value = val;
    }

    public T get() {
        return value;
    }

    @Override public boolean equals(Object obj) {
        return value.equals(obj);
    }

    public static void main(String[] args) {
        Holder<Apple> apple = new Holder<>(new Apple());
        Apple d = apple.get();
        apple.set(d);

        //Fruit的容器 与Apple的容器 不存在继承关系  不能向上转型
//        Holder<Fruit> fruit = apple;

        // Holder<? extends Fruit> 是 Holder<Fruit> Holder<Apple>的基类
        // 所以可以如此赋值
        Holder<? extends Fruit> fruit = apple;

        // Holder<? extends Fruit> 返回的是  Fruit类型
        Fruit p = fruit.get();
        d = (Apple)fruit.get();
    }
}
