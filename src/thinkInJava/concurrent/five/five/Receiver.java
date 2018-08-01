package thinkInJava.concurrent.five.five;

import java.io.IOException;
import java.io.PipedReader;

/**
 * @author Will
 * @date 2018/8/1.
 */
public class Receiver implements Runnable {
    private PipedReader in;

    public Receiver(Sender sender) throws IOException {
        in = new PipedReader(sender.getPipedWriter());
    }

    @Override public void run() {
        try {
            while (true) {
                // Blocks until characters are there
                System.out.println("Read: " + (char)in.read() + ", ");
            }
        } catch (IOException e) {
            System.out.println(e + " Receiver read exception");
        }
    }
}
