package thinkInJava.generic.three.coff;

import java.util.Iterator;
import java.util.Random;

/**
 * @author Will
 * @date 2018/8/14.
 */
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
    private Class[] types = {Latte.class, Mocha.class, Cappuccino.class,
        Americano.class, Breve.class};

    private static Random rand = new Random(47);

    private int size = 0;


    public CoffeeGenerator() {}

    public CoffeeGenerator(int size) {
        this.size = size;
    }

    @Override public Coffee next() {
        try {
            return (Coffee) types[rand.nextInt(types.length)]
                .getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    class CoffeeInterator implements Iterator<Coffee> {
        int count = size;

        @Override public boolean hasNext() {
            return count > 0;
        }

        @Override public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }

        // not implemented
        @Override public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    @Override public Iterator<Coffee> iterator() {
        return new CoffeeInterator();
    }

    public static void main(String[] args) {
        CoffeeGenerator gen = new CoffeeGenerator();

        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }

        for (Coffee c : new CoffeeGenerator(5)) {
            System.out.println(c);
        }
    }


}
