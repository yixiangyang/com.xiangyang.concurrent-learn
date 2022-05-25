package com.xiangyang.concurrent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * suspend\resume\stop 不建议使用 因为容易发生死锁
 *
 * @Author yixiangyang
 * @Date 2022/4/18 19:54
 */
public class Deprecated {
    public static void main(String[] args) throws Exception{
        DateFormat format = new SimpleDateFormat("HH:mm:ss");
        Thread printThread = new Thread(new Runner(),"PrintThread");
        printThread.setDaemon(true);
        printThread.start();
        TimeUnit.SECONDS.sleep(3);
        //将printThread 进行暂停，输出内容工作停止。
        printThread.suspend();

        System.out.println("main suspend PrintThread at"+ format.format(new Date()));
        TimeUnit.SECONDS.sleep(3);

        //将printThread 进行恢复
        printThread.resume();
        System.out.println("main resume PrintThread at"+ format.format(new Date()));
        TimeUnit.SECONDS.sleep(3);
        //将printThread 进行终止
        printThread.stop();
        System.out.println("main stop PrintThread at"+ format.format(new Date()));
        TimeUnit.SECONDS.sleep(3);
    }

    static class Runner implements Runnable{

        @Override
        public void run() {
            DateFormat format = new SimpleDateFormat("HH:mm:ss");
            while (true){
                System.out.println(Thread.currentThread().getName()+"run at" +format.format(new Date()));
                SleepUtils.second(1);
            }
        }
    }
}
