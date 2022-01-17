package com.multiThread;

/**
 * @author nj
 * @date 2022/1/17 5:26 PM
 * 使用yield将cpu让给其它资源, 会导致运行时间增加
 * priority: 高优先级的线程，会被线程规划器优先执行
 * 线程的优先级具有继承性, 若A线程启动B线程，则B线程的优先级与A线程一致
 **/
public class Test7 {
    public static void main(String[] args) {
//        ThreadD t = new ThreadD();
//        t.start();

        Thread.currentThread().setPriority(4);
        ThreadE t2 = new ThreadE();
        t2.start();
    }
}

class ThreadE extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("thread.priority: " + this.getPriority());
        ThreadD t = new ThreadD();
        t.start();
    }
}

class ThreadD extends Thread {
    @Override
    public void run() {
        System.out.println("threadD.priority: " + this.getPriority());
        super.run();
        int count = 1;
        long start = System.currentTimeMillis();
        for (int i=0; i<50000000; i++) {
            // 测试yield方法, 耗时会成百倍的增长 use time: 19759ms, 不加yield只有20ms左右
//            Thread.yield();
            count = count + (i+1);
        }
        long end = System.currentTimeMillis();
        System.out.println("use time: " + (end - start) + "ms" );
    }
}
