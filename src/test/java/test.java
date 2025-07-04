import java.awt.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1、java：Thread.start()方法 ----> 调用 start0() 本地方法 ---->JVM： jvm_startTread 方法 -----> linux OS : PTread Create_thread 创建一个线程
 * 2、新创建的线程状态时 初始化 ，通过 JVM notify() 方法 唤醒，修改线程状态为 runnable ，此时线程就是可以执行了，只等cpu 分配时间片
 * 3、得到时间片后，OS 会回调 java 线程的RUN 方法，执行线程
 *
 *
 *
 *
 * 中断机制：t.interrupt();
 *  比 stop 更加优雅的结束线程的方式
 *
 *  中断 只是给线程发送一个 需要中断的 flag 信号 ，具体是否停止，是目标线程判断的；
 *  thread.sleep / wait 方法 都会清除 这个flag 信号，一般需要在 异常处理时补上
 *
 *
 *  等待唤醒机制：
 *  1、wait / notify 配合 synchronized 使用
 *  2、LockSupport.park/unPark(Thread)
 * @author zhouxh-z
 * @date 2021/11/10 10:56
 */
public class test {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        ReentrantLock reentrantLock1 = new ReentrantLock();


        new Thread(()->{
            reentrantLock.lock();
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            reentrantLock1.lock();
            System.out.println("111111111111");
        }).start();

        new Thread(()->{
            reentrantLock1.lock();
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            reentrantLock.lock();
            System.out.println("222222222222");

        }).start();

    }
}
