package lock.doubleCheckLock;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: DoubleCheckLockVersion1
 * @Description: 双检锁第一版；线程不安全
 * @Author: wuwx
 * @Date: 2019-03-21 15:13
 **/
public class DoubleCheckLockVersion1 {

    private TestObject instance;

    public TestObject getInstance(){
        if(instance == null){
            instance = new TestObject();
        }
        System.out.println(instance.toString());
        return instance;
    }


    @Test
    public void test() throws InterruptedException {
        ExecutorService es1 = Executors.newFixedThreadPool(2);
        ExecutorService es2 = Executors.newSingleThreadExecutor();
        while (true) {
            //TimeUnit.MILLISECONDS.sleep(50);
            es1.submit(() -> getInstance());
            //es2.submit(() -> getInstance());
        }

    }

}
