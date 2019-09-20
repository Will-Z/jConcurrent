package concuPrac2.c5.c10.c2;

import java.nio.ByteBuffer;
import java.util.LinkedList;

/**
 * @author will
 * @date 2019/9/9
 */
public class EchoClient {
    private LinkedList<ByteBuffer> outq;

    EchoClient() {
        outq = new LinkedList<ByteBuffer>();
    }

    public LinkedList<ByteBuffer> getOUtputQueue() {
        return outq;
    }

    public void enqueue(ByteBuffer bb) {
        outq.addFirst(bb);
    }
}
