package threadException.mutilThread;

/**
 * @ClassName: MyThreadUncaughExceptionHandler
 * @Description: 自定义的线程异常处理器；
 * @Author: wuwx
 * @Date: 2019-01-25 19:16
 **/
public class MyThreadUncaughExceptionHandler implements Thread.UncaughtExceptionHandler {
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("异常处理器，捕获到异常："+e);
    }
}
