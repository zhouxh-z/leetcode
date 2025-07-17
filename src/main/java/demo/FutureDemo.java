package demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author zhouxianghui6
 * @description
 * @date 2025/7/17
 */
public class FutureDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // future 本身只是任务 不具备执行能力,但是FutureTask 还继承了 Runnable
        FutureTask future = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                Thread thread = Thread.currentThread();
                System.out.println("first future : " + thread.getName());
                return "first future return";
            }
        });
        new Thread(future).start();
        Object o = future.get();

        System.out.println(o);
    }
}
