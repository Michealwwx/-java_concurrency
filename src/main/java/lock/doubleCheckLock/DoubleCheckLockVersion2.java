package lock.doubleCheckLock;

/**
 * @ClassName: DoubleCheckLockVersion2
 * @Description: 双检锁第二个版本，粗粒度的并发控制
 * @Author: wuwx
 * @Date: 2019-03-21 16:54
 **/
public class DoubleCheckLockVersion2 {

    private TestObject instance;

    //粗粒度
    public synchronized TestObject getInstance() {

        if (instance == null) {
            instance = new TestObject();
        }
        return instance;
    }

    //细粒度双检锁; FIXME 问题
    public TestObject getInstance1() {
        if (instance == null) {
            synchronized (DoubleCheckLockVersion2.class) {
                if (instance == null) {
                    instance = new TestObject();
                }
            }
        }
        return instance;
    }


    //解决方案 1.基于volatile

    public void test() {


    }


}
