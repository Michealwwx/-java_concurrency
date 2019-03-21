package threadException.singleThread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: singleThread.SingleThreadException
 * @Description: 单线程处理异常； 单线程中如果出现异常并且没有进行捕获时，程序就会停止；
 * 必须用将异常catch住；
 * @Author: wuwx
 * @Date: 2019-01-25 18:00
 **/
public class SingleThreadException implements Runnable{
    private volatile int count = 0;

    private ExecutorService schedule = Executors.newScheduledThreadPool(1);

    @Test
    public void test(){
        schedule.submit(new SingleThreadException());
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
                count++;
                System.out.println("数："+count);
                //throw new RuntimeException();
            } catch (Exception e) {
                System.out.println("线程异常信息：" + e);
            }
        }
    }
}
