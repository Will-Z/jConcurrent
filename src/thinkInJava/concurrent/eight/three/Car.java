package thinkInJava.concurrent.eight.three;

/**
 * @author Will
 * @date 2018/8/6.
 */
public class Car {
    private int id;
    private boolean engine = false, driveTrain = false, wheels = false;

    public Car(int idn) {
        id = idn;
    }

    // empty Car object;
    public Car() {
        id = -1;
    }

    public synchronized int getId() {
        return id;
    }

    public synchronized void addEngine() {
        engine = true;
    }

    public synchronized void addDriveTrain() {
        driveTrain = true;
    }

    public synchronized void addWheels() {
        wheels = true;
    }

    @Override public synchronized String toString() {
        return "Car " + id + " ["  + " engine: " + engine + " driveTrain: " + driveTrain
            + " wheels: " + wheels + " ]";
    }
}
