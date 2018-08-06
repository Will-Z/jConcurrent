package thinkInJava.concurrent.eight.three;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Will
 * @date 2018/8/6.
 */
public class RobotPool {
    private Set<Robot> pool = new HashSet<Robot>();

    public synchronized void add(Robot r) {
        pool.add(r);
        notifyAll();
    }

    public synchronized void hire(Class<? extends Robot> robotType, Assembler d)
        throws InterruptedException {
        for (Robot r : pool) {
            if (r.getClass().equals(robotType)) {
                pool.remove(r);
                r.assignAssembler(d);
                r.engage();  // power it up to do the task
                return;
            }
        }
        wait();  // none available
        hire(robotType, d);  // try agin recursively
    }

    public synchronized void release(Robot r) {
        add(r);
    }
}
