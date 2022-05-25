package com.xiangyang.concurrent;

/**
 * 守护线程，在Java虚拟机推出Daemon线程中的finally块不一定会执行。
 * 注意：在构建Daemon线程时，不能依靠finally块中的内容来确保执行关闭或清理资源的逻辑。
 * @Author yixiangyang
 * @Date 2022/4/18 19:23
 */
public class Daemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(),"DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }

    static class DaemonRunner implements Runnable{

        @Override
        public void run() {
            try {
                SleepUtils.second(100);
            }finally {
                System.out.println("DaemonThread finally run.");
            }
        }
    }
}
