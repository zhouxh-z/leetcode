package demo;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author zhouxianghui6
 * @description
 * @date 2025/7/17
 */
public class CompletableFutureDemo {

    public static void main(String[] args) {
        CompletableFutureDemo completableFutureDemo = new CompletableFutureDemo();
        completableFutureDemo.test1();
    }

    public void test(){
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        completableFuture.thenAccept(new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println( o );
                System.out.println( Thread.currentThread().getName() );
            }
        });
        // 同步调用
        completableFuture.complete("ok");
    }

    public void test1(){
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        completableFuture.thenAccept(new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println( o + "1");
                System.out.println( Thread.currentThread().getName() );
            }
        });
        // 同步调用
        CompletableFuture<Object> objectCompletableFuture = CompletableFuture.supplyAsync(new Supplier<Object>() {
            @Override
            public Object get() {
                System.out.println(1);
                return completableFuture;
            }
        });
        objectCompletableFuture.thenRunAsync(() -> System.out.println("objectCompletableFuture ok"));
        completableFuture.thenRunAsync(() -> System.out.println("ok"));
    }
}
