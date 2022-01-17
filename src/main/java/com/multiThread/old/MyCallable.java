package com.multiThread.old;

import java.util.concurrent.*;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        String t = " return value ";
        System.out.println("ready to work.");
        Thread.sleep(2000);
        System.out.println("work done");
        return t;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        FutureTask<String> task = new FutureTask<>(new MyCallable());
//        new Thread(task).start();
//        if (!task.isDone()) {
//            System.out.println("task hash not done, please wait.");
//        }
//        System.out.println("task value = " + task.get());

        // 通过线程池获取
        ExecutorService service = Executors.newFixedThreadPool(1);
        Future<String> future = service.submit(new MyCallable());
        if (!future.isDone()) {
            System.out.println("work not done, please wait.");
        }
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            service.shutdown(); // 必须把线程池关闭
        }
    }
}
