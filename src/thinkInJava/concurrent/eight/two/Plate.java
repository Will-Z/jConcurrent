package thinkInJava.concurrent.eight.two;

/**
 * @author Will
 * @date 2018/8/5.
 */
public class Plate {
    private Order order;
    private Food food;

    public Plate(Order ord, Food f) {
        order = ord;
        food = f;
    }

    public Order getOrder() {
        return order;
    }

    public Food getFood() {
        return food;
    }

    @Override public String toString() {
        return food.toString();
    }
}
