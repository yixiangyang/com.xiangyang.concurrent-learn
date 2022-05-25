package com.xiangyang.concurrent;

/**
 * @Author yixiangyang
 * @Date 2022/4/4 22:05
 */
public class ConcurrencyTest {

    private static final long count = 1000001;
    public static void main(String[] args) throws InterruptedException {
        concurrentcy();
        serial();
    }

    private static void concurrentcy() throws InterruptedException {
        long start = System.currentTimeMillis();

        Thread thread = new Thread(()->{
            int a = 0;
            for(int i =0 ;i< count;i++){
                a += 5;
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for(int i =0 ;i< count;i++){
                    a += 5;
                }
            }
        });
        thread.start();
        thread2.start();
        int b = 0;
        for(long i=0;i<count ;i++){
            b--;
        }
        thread.join();
        thread2.join();
        long time = System.currentTimeMillis()-start;
        System.out.println("concurrentcy :"+time+"ms,b="+b);
    }

    private static void serial(){
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i =0;i <count;i++){
            a+=5;
        }
        int b =0;
        for(long i =0;i<count;i++){
            b--;
        }
        long time = System.currentTimeMillis()-start;
        System.out.println("serial :"+time+"ms,b="+b);
    }

}
