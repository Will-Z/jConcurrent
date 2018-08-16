package thinkInJava.generic.four.four.test;

import thinkInJava.generic.four.four.BasicGenerator;
import thinkInJava.generic.three.coff.Generator;

/**
 * @author Will
 * @date 2018/8/15.
 */
public class BasicGeneratorDemo {
    public static void main(String[] args) {
        Generator<CountedObject> gen = BasicGenerator.create(CountedObject.class);

        for (int i = 0; i < 10; i++) {
            System.out.println(gen.next());
        }
    }
}
