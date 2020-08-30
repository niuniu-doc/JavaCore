package org.example.concurrent;

/**
 * 缓存导致的多线程问题
 */
public class Test1 {
    private static long count = 0;
    private void add10K() {
        int i = 0;
        while (i++ < 10000) {
            count += 1;
        }
    }

    public static long calc() throws InterruptedException {
        final Test1 test1 = new Test1();

        // 创建两个线程、执行add操作
        /**
         * 猜测结果应该是20000, 但实际结果应该是 10k - 20k 之间的一个随机数,
         * 第一次加载、都会把count=0读入cpu缓存, 但后续各线程计算完 count+1 会写回缓存、
         * 下次从缓存得到的值就是1
         */
        Thread t1 = new Thread(() -> {
            test1.add10K();
        });

        Thread t2 = new Thread(() -> {
            test1.add10K();
        });

        t1.start();
        t2.start();

        // 等待两个线程执行结束
        t1.join();
        t2.join();

        return count;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(calc());
    }

}
