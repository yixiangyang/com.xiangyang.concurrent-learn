package com.xiangyang.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @Author yixiangyang
 * @Date 2022/4/18 16:45
 */
public class SleepUtils {
    public static final void second(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
