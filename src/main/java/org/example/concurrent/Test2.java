package org.example.concurrent;

/**
 * 线程切换导致的多线程问题
 */
public class Test2 {
    /**
     * 早期系统是基于进程调度, 进程切换需要重新映射内存地址; 线程是共享内存空间的.
     * 现在一般是基于线程的轻量级调度.
     * 对于需要多个CPU指令的语句来说、可能会在任意一个指令执行完成时发生 线程切换,
     * 导致多线程问题
     * 系统只保证指令级别的原子性(操作不会中断)、而非语言级别.
     */

    /**
     * 编译器优化异常
     * eg. new Singleton 操作,
     * 我们的认为是: 先 分配内存 -> 内存初始化 -> 变量赋值
     * 实际操作: 先 分配内存 -> 变量赋值 -> 内存初始化
     * 则: 在变量赋值之后的线程切换就可能导致拿到未初始化的变量
     */
    // 所以在使用优化的时候、我们最好知道 它的问题是什么、如何规避

    private static class Singleton {
        static Singleton instance;
        static Singleton getInstance() {
            if (instance == null) {
                synchronized (Singleton.class){
                    if (instance == null) {
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }
    }


}
