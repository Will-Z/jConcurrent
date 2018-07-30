package thinkInJava.concurrent.three.five.explicit;

import thinkInJava.concurrent.three.five.CriticalSection;
import thinkInJava.concurrent.three.five.PairManager;

/**
 * [X ?]
 *
 * 报异常, 代码与原书相同, 暂清楚 出错机制
 *
 * 测试两个使用显示的Lock对象 来进行同步的方法
 *
 * @author Will
 * @date 2018/7/20.
 */
public class ExplicitCriticalSection {
    public static void main(String[] args ) throws Exception {
        PairManager
            pman1 = new ExplicitPairManager1(),
            pman2 = new ExplicitPairManager2();

        CriticalSection.testApproaches(pman1, pman2);
    }
}
