package com.multiThread.imooc.test01;

// 此处继承 Thread 实现
public class StudentMulti extends Thread{
    String name;
    Punishment punishment;

    StudentMulti(String name, Punishment punishment) {
        this.name = name;
        this.punishment = punishment;
    }

    public void copyWord() {
        int count = 0;
        String threadName = Thread.currentThread().getName();

        while (true) {
            if (punishment.getLeftCopyCount()>0) {
                int leftCopyCount = punishment.getLeftCopyCount();
                System.out.println(threadName + " 线程, " + name + " 还要抄写 " + --leftCopyCount + " 次");
                punishment.setLeftCopyCount(leftCopyCount);
                count++;
            } else {
                break;
            }
        }
        System.out.println(threadName + " 线程, " + name + " 一共抄写了 " + count + "次");
    }

    @Override
    public void run() {
        copyWord();
    }
}
