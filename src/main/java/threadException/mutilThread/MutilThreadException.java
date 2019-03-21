package threadException.mutilThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: MutilThreadException
 * @Description: 多线程中处理异常；
 * @Author: wuwx
 * @Date: 2019-01-25 18:05
 **/
public class MutilThreadException implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName());
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        try {
            ExecutorService es = Executors.newCachedThreadPool(new HandlerThreadFactory());
            while (true) {
                Thread.sleep(100);
                es.execute(new MutilThreadException());
            }
        } catch (Exception e) {
            System.out.println("异常信息：" + e);
        }

    }
}
