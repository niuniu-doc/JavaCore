package com.multiThread;

/**
 * @author nj
 * @date 2022/1/17 3:16 PM
 * sleep 在指定ms内, 让当前正在执行的this.currentThread线程休眠,
 * getId 获取线程id
 **/
public class Test5 {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println(t.getName() + ", " + t.getId());
    }
}
