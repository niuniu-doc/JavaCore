package com.multiThread.imooc.test01;

import com.sun.javafx.tk.Toolkit;

public class StudentSynchronized implements Runnable{
    String name;
    Punishment punishment;

    public StudentSynchronized(String name, Punishment punishment) {
        this.name = name;
        this.punishment = punishment;
    }

    public void copyWord() {
        int count = 0; // 用来计数
        String threadName = Thread.currentThread().getName();

//        while (true) {
//            if (punishment.getLeftCopyCount() > 0) {
//                int leftCount = punishment.getLeftCopyCount();
//                if (leftCount == punishment.getLeftCopyCount()) {
//                    punishment.setLeftCopyCount(leftCount-1);
//                    System.out.println(threadName + "线程-" + name + "抄写" + punishment.getWord() + "。还要抄写" + (leftCount-1) + "次");
//                    count++;
//                }
//            } else {
//                break;
//            }
//            System.out.println(threadName + " 线程, " + name + " 一共抄写了 " + count + "次");
//        }

        // 使用synchronize实现同步
        while (true) {
            int leftCount = 0;
            synchronized (punishment.getLeftCopyCount()) {
                leftCount = punishment.getLeftCopyCount();
                punishment.setLeftCopyCount(leftCount - 1);
            }

            if (punishment.getLeftCopyCount() > 0) {
                System.out.println(threadName + "线程-" + name + "抄写" + punishment.getWord() + "。还要抄写" + leftCount + "次");
                count ++;
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
