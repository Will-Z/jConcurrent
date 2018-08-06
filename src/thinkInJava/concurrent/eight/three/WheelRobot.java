package thinkInJava.concurrent.eight.three;

/**
 * @author Will
 * @date 2018/8/6.
 */
public class WheelRobot extends Robot {
    public WheelRobot(RobotPool pool) {
        super(pool);
    }

    @Override protected void performService() {
        System.out.println(this + " installing Wheels");
        assembler.car().addWheels();
    }
}
