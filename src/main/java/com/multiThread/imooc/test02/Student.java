package com.multiThread.imooc.test02;

import java.util.LinkedList;

public class Student extends Thread{

    String name;
    LinkedList<Task> tasks;

    public Student(String name, LinkedList<Task> tasks) {
        super(name);
        this.name = name;
        this.tasks = tasks;
    }

    public void copyWord() throws InterruptedException{
        while (true) {
            Task task = null;
            synchronized (tasks) {
                if (tasks.size() > 0) {
                    // copy
                    task = tasks.removeFirst();
                    sleep(100);
                    tasks.notifyAll();
                } else {
                    System.out.println(name + " start wait, no task. ");
                    tasks.wait();
                    System.out.println(name + " end wait, task arrive. ");
                }
            }

            if (task != null) {
                // do task
                for (int i = 0; i < task.getLeftCount(); i++) {
                    System.out.println(name + " do task, this is " + i + " task is " + task.getWords());
                }
            }
        }
    }

    @Override
    public void run() {
        try {
            copyWord();
        } catch (Exception e ){

        }

    }
}
