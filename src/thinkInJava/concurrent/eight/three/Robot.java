package thinkInJava.concurrent.eight.three;

import java.util.concurrent.BrokenBarrierException;

/**
 * @author Will
 * @date 2018/8/6.
 */
public abstract class Robot  implements Runnable {
    private RobotPool pool;
    protected Assembler assembler;
    private boolean engage = false;

    public Robot(RobotPool p) {
        pool = p;
    }

    public Robot assignAssembler(Assembler assembler) {
        this.assembler = assembler;
        return this;
    }

    public synchronized void engage() {
        engage = true;
        notifyAll();
    }

    // the part of run() that's different for each robot:
    abstract protected void performService();

    private synchronized void powerDown() throws InterruptedException {
        engage = false;
        assembler = null; // disconnect from the assembler

        // put ourselves back in the available pool;
        pool.release(this);
        while (!engage) {
            wait();
        }
    }

    @Override public String toString() {
        return getClass().getName();
    }

    @Override public void run() {
        try {
            powerDown();    // wait until needed
            while (!Thread.interrupted()) {
                performService();
                assembler.barrier().await();   // synchronize

                // we're done with that job
                powerDown();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting " + this + " via interrupt");
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this + " off");
    }
}
