package concuPrac2.c5.c5.c3;

import java.util.concurrent.Callable;

/**
 * @author will
 * @date 2019/9/5
 */
public class RealData implements Callable<String> {
    private String param;
    public RealData(String param) {
        this.param = param;
    }

    @Override
    public String call() throws Exception {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(param);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        return sb.toString();
    }
}
