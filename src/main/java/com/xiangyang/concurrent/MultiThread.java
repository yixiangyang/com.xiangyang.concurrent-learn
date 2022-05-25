package com.xiangyang.concurrent;


import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @Author yixiangyang
 * @Date 2022/4/17 18:44
 */
public class MultiThread {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean =  ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);
        for (ThreadInfo threadInfo:threadInfos){
            System.out.println(threadInfo.getThreadId() +" name:"+threadInfo.getThreadName());
        }
    }
}
