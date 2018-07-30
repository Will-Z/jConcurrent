package thinkInJava.concurrent.two.twelve;

/**
 * @author Will
 * @date 2018/7/19.
 */
public class ResponsiveUI extends Thread {
    private static volatile double d = 1;

    public ResponsiveUI() {
        setDaemon(true);
        start();
    }

    @Override public void run() {
        while (true) {
            d += (Math.PI + Math.E) / d;
        }
    }

    public static void main(String[] args) throws Exception {
        new ResponsiveUI();
        System.in.read();
        System.out.println(d);
    }
}
