package com.xiangyang.concurrent.threadPool;

import java.util.concurrent.*;

/**
 * @Author yixiangyang
 * @Date 2022/5/7 19:50
 */
public class Callable {
    public static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 50, 300, TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(50),
            new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {
                    return new Thread(r,"schema_task_pool_"+r.hashCode());
                }
            },new ThreadPoolExecutor.DiscardOldestPolicy());

    public static void callableTest(){
        int a = 1;
        //callable
        Future<Boolean> future = threadPool.submit(new java.util.concurrent.Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                int b = a+100;
                System.out.println(b);
                return true;
            }
        });
        try {
            System.out.println("feature.get");
            Boolean boolean1 = future.get();
            System.out.println(boolean1);
        }catch (InterruptedException e){
            System.out.println("InterruptedException...");
            e.printStackTrace();
        }catch (ExecutionException e){
            System.out.println("execute exception...");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        callableTest();
    }
}
