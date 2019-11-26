package play;


/**
 * @author will
 * @date 2019/9/20
 */
public class Hello {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;

        System.out.println(c == d);         // F  T
        System.out.println(e == f);         // T  F
        System.out.println(c == (a + b));   // T  T
        System.out.println(c.equals(a + b));// T  T
        System.out.println(g == (a + b));   // T  T
        System.out.println(g.equals(a + b));// T  F








    }
}
