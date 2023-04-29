package myLab.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class BasicUsage {

    public static void main(String[] args) throws InterruptedException {
        BasicUsage basicUsage = new BasicUsage();
        basicUsage.simpleUsage();
    }

    public void simpleUsage() throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("thread 1 start");
        }, "first");
        thread.setPriority(3);
        Thread.currentThread();
        Thread.currentThread().getThreadGroup();
        thread.start();
        Thread.yield();
        Thread.sleep(10);
        thread.join();
    }

    // 自定义Callable
    class MyTask implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            // 模拟计算需要一秒
            Thread.sleep(1000);
            return 2;
        }

        public void callableUsage() throws InterruptedException, ExecutionException {
            // 使用
            ExecutorService executor = Executors.newCachedThreadPool();
            MyTask task = new MyTask();
            Future<Integer> result = executor.submit(task);
            // 注意调用get方法会阻塞当前线程，直到得到结果。
            // 所以实际编码中建议使用可以设置超时时间的重载get方法。
            System.out.println(result.get());
        }

        public void futureTaskUsage() throws InterruptedException, ExecutionException{
            // 使用
            ExecutorService executor = Executors.newCachedThreadPool();
            FutureTask<Integer> futureTask = new FutureTask<>(new MyTask());
            executor.submit(futureTask);
            System.out.println(futureTask.get());
        }
    }
}
