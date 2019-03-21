package threadException.mutilThread;

import java.util.concurrent.ThreadFactory;

/**
 * @ClassName: HandlerThreadFactory
 * @Description: 线程工厂
 * @Author: wuwx
 * @Date: 2019-01-25 19:35
 **/
public class HandlerThreadFactory implements ThreadFactory {
    public Thread newThread(Runnable r) {
        System.out.println(this+"创建新线程");
        Thread thread = new Thread(r);
        System.out.println("创建完成"+thread);
        thread.setUncaughtExceptionHandler(new MyThreadUncaughExceptionHandler());
        System.out.println("获取线程异常处理器："+thread.getUncaughtExceptionHandler());
        return thread;
    }
}
