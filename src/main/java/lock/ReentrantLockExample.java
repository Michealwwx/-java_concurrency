package lock;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: ReentrantLockExample
 * @Description: 重入锁
 * @Author: wuwx
 * @Date: 2019-03-20 09:50
 **/
public class ReentrantLockExample {

    private int a = 0;
    private ReentrantLock lock = new ReentrantLock();

    public void write(){
        lock.lock();
        System.out.println("WriteHoldCount"+lock.getHoldCount());
        try {
            a++;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void read(){
        lock.lock();
        try {
            System.out.println("ReadHoldCount"+lock.getHoldCount());
            int i = a;
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        lock.unlock();
        }

    }

    @Test
    public void test() throws InterruptedException {
        ExecutorService es1 = Executors.newSingleThreadExecutor();
        ExecutorService es2 = Executors.newSingleThreadExecutor();
        while (true) {
            TimeUnit.MILLISECONDS.sleep(100);
            es1.submit(() -> { write(); });
            es2.submit(() -> read());
        }
    }

}
