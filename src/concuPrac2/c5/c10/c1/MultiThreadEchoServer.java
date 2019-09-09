package concuPrac2.c5.c10.c1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 基于Socket的服务端多线程模式.
 *
 * 一个支持多线程的服务端的核心内容.
 * 在相同可支持的线程范围内, 尽量多的支持客户端的数量.
 *
 * 缺点: 它倾向于让CPU进行IO等待. 如HeavySocketClient
 *
 * @author will
 * @date 2019/9/5
 */
public class MultiThreadEchoServer {
    private static ExecutorService tp = Executors.newCachedThreadPool();

    static class HandleMsg implements Runnable {
        Socket clientSocket;
        public HandleMsg(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            BufferedReader is = null;
            PrintWriter os = null;
            try {
                is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                os = new PrintWriter(clientSocket.getOutputStream(), true);
                // 从 InputStream中读取客户端所发送的数据
                String inputLine = null;
                long begin = System.currentTimeMillis();
                while ((inputLine = is.readLine()) != null) {
                    os.println(inputLine);
                }
                long end = System.currentTimeMillis();
                System.out.println("spend:" + (end-begin) + "ms");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (is != null) {
                        is.close();
                    }
                    if (os != null) {
                        os.close();
                    }
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ServerSocket echoServer = null;
        Socket clientSocket = null;
        try {
            echoServer = new ServerSocket(8000);
        } catch (IOException e) {
            System.out.println(e);
        }

        while (true) {
            try {
                clientSocket = echoServer.accept();
                System.out.println(clientSocket.getRemoteSocketAddress() + " connect!");
                tp.execute(new HandleMsg(clientSocket));
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
