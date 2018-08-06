package thinkInJava.concurrent.eight.three;

/**
 * @author Will
 * @date 2018/8/6.
 */
public class DriveTrainRobot extends Robot {
    public DriveTrainRobot(RobotPool pool) {
        super(pool);
    }

    @Override protected void performService() {
        System.out.println(this + " installing DriveTrain");
        assembler.car().addDriveTrain();
    }
}
