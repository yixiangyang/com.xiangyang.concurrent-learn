package com.xiangyang.concurrent;

/**
 * @Author yixiangyang
 * @Date 2022/4/5 18:03
 */
public class Test {
    private volatile static boolean flag = false;

    public static void main(String[] args) {
        long i = 0L;
        flag = true;
        while (!flag) {
            i++;
        }
        System.out.println("count = " + i);
        flag = true;
    }

}
