package com.multiThread;

/**
 * @author nj
 * @date 2022/1/17 3:22 PM
 * 停止线程:
 * 1. 可以使用 Thread.stop 但最好不要使用, unsafe/deprecated, 未来可能不再支持
 * 2. interrupt 中断
 * 3. run方法运行完毕, 自动退出
 *
 * 注意: interrupt 并不会立即终止线程, 只是给线程加上终止标记
 * this.interrupted 判断当前线程是否已中断, 当前: 指运行 this.interrupted 的线程
 *    会清除中断状态 (main)
 * this.isInterrupted 判断线程Thread对象是否已中断, 不清除中断标志 (thread)
 *
 * 能停止线程的方法
 * 1. 异常法，若在sleep状态下停止某一线程，会进入catch并清除停止状态值, 变成false(建议, 可将异常向上传递)
 * 2.
 *
 * yield 是放弃cpu资源, 但有可能马上再次被调度
 *
 **/
public class Test6 {
    public static void main(String[] args) {
        Thread t = new ThreadC();
        t.start();
        t.interrupt();
        System.out.println(Thread.interrupted());
        System.out.println(Thread.interrupted());
        System.out.println(t.isInterrupted());
        System.out.println(t.isInterrupted());
    }
}

class ThreadC extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                if (this.isInterrupted()) {
                    System.out.println("线程被中断了, 会退出执行");
                    break; // for 下边儿的语句继续被执行, 可以抛出异常, 并处理
                    // throw new InterruptedException("interrupted.");
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
