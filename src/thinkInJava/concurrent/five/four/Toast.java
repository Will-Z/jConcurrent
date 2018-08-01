package thinkInJava.concurrent.five.four;

/**
 * @author Will
 * @date 2018/8/1.
 */
public class Toast {
    public enum Status { DRY, BUTTERED, JAMMED}

    private Status status = Status.DRY;

    private int id;

    public Toast (int idn) {
        id = idn;
    }

    public void butter() {
        status = Status.BUTTERED;
    }

    public void jam() {
        status = Status.JAMMED;
    }

    public Status getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    @Override public String toString() {
        return "Toast " + id + ": " + status;
    }
}
