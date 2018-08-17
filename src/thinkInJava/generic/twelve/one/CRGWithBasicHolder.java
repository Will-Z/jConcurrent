package thinkInJava.generic.twelve.one;

/**
 * @author Will
 * @date 2018/8/17.
 */
public class CRGWithBasicHolder {
    public static void main(String[] args) {
        Subtype st1 = new Subtype(),
                st2 = new Subtype();

        st1.set(st2);
        Subtype st3 = st1.get();
        st1.f();
    }
}
