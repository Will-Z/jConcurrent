package thinkInJava.concurrent.five.three;

/**
 * @author Will
 * @date 2018/7/31.
 */
public class Meal {
    private int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override public String toString() {
        return "Meal " + orderNum;
    }
}
