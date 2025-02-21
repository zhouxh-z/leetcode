package theory;

import sun.misc.Unsafe;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.LockSupport;

/**
 * @author zhouxianghui6
 * @description
 * @date 2025/2/20
 */
public class AQS {
    // unsafe 提供 acs 操作
    public static Unsafe unsafe = Unsafe.getUnsafe();

    public static Thread thread;
    // 缓存 线程对象
    ConcurrentLinkedQueue<Thread> queue = new ConcurrentLinkedQueue<>();
    // 锁状态 - 保障线程可见，acs 实现
    private static volatile int status = 0;
    private static long offset ;

    static {
        try {
            offset = unsafe.objectFieldOffset(AQS.class.getField("status"));
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }


    // 尝试加锁
    public boolean tryQ(Thread thread){
        // 尝试加锁
        if (unsafe.compareAndSwapInt(status,offset,0,1)) {
            AQS.thread = thread;
            return true;
        }
        return false;
    }
    // 解锁
    public void lock(){
        Thread thread = Thread.currentThread();
        if (tryQ(thread)) {
            return;
        }

        queue.add(Thread.currentThread());

        while (true){
            thread = queue.peek();
            if (tryQ(thread)) {
                queue.poll();
                return;
            }
            //阻塞线程  为了休眠住，避免一直尝试加锁
            LockSupport.park();
        }
    }

    // 解锁
    public void unlock(){
        Thread thread = queue.peek();
        if (unsafe.compareAndSwapInt(status,offset,1,0)) {
            AQS.thread = null;
        }
        LockSupport.unpark(thread);
    }
}
