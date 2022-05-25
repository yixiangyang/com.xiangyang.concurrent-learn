package com.xiangyang.concurrent;

/**
 * 死锁demo
 * @Author yixiangyang
 * @Date 2022/4/5 13:18
 */
public class DeadLockDemo {

    private static String A = "A";

    private static String B = "B";

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }

    private void deadLock(){
        Thread thread1 = new Thread(()->{
            synchronized (A){
                try {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (B){
                    System.out.println(1);
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B){
                    synchronized (A){
                        System.out.println(2);
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
