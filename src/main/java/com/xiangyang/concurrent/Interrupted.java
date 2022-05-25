package com.xiangyang.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * sleep 线程一直睡眠 busy 线程一直运行
 *
 * 运行结果表示。抛出InterruptedException的线程SleepThread，其中断表示为被清除了，
 * 而一直忙碌运作的线程BusyThread,中断标识位没有被清除。
 * @Author yixiangyang
 * @Date 2022/4/18 19:42
 */
public class Interrupted {
    public static void main(String[] args) throws Exception {
        //不停的尝试睡眠
        Thread sleepThread = new Thread(new SleepRunner(),"SleepThread");
        sleepThread.setDaemon(true);
        //不停的运行。
        Thread busyThread = new Thread(new BusyRunner(),"BusyThread");
        sleepThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();
        //休眠5秒 ，让sleepThread 和busyThread充分运行。
        TimeUnit.SECONDS.sleep(5);
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("SleepThread interrupt is "+sleepThread.isInterrupted());
        System.out.println("BusyThread interrupt is "+busyThread.isInterrupted());
        //防止sleepThread 和busyThread 立即退出
        SleepUtils.second(2);
    }

    static class SleepRunner implements Runnable{

        @Override
        public void run() {
            while (true){
                SleepUtils.second(100);
            }
        }
    }

    static class BusyRunner implements Runnable{

        @Override
        public void run() {
            while (true){

            }
        }
    }
}
