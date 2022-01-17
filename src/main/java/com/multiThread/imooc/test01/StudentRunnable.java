package com.multiThread.imooc.test01;

public class StudentRunnable implements Runnable{
    String name;
    Punishment punishment;

    public StudentRunnable(String name, Punishment punishment) {
        this.name = name;
        this.punishment = punishment;
    }

    public void copyWord() {
        int count = 0;
        String threadName = Thread.currentThread().getName();

        while (true) {
            synchronized (punishment) {
                if (punishment.getLeftCopyCount()>0) {
                    int leftCopyCount = punishment.getLeftCopyCount();
                    leftCopyCount--; //先将共享变量的值 -1
                    if (leftCopyCount < punishment.getLeftCopyCount()) {
                        // 判断 共享变量的值是不是 小于 当前值，防止把别的线程修改后的数据覆盖掉
                        punishment.setLeftCopyCount(leftCopyCount);
                    }
                    System.out.println(threadName + " 线程, " + name + " 还要抄写 " + --leftCopyCount + " 次");
                    count++;
                } else {
                    break;
                }
            }
        }
        System.out.println(threadName + " 线程, " + name + " 一共抄写了 " + count + "次");
    }

    @Override
    public void run() {
        copyWord();
    }
}
