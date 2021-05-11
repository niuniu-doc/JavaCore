package com.multiThread.imooc.test02;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Teacher extends Thread{

    String name;
    List<String> words = Arrays.asList("internationalization", "hedgehog", "penicillin", "oasis", "nirvana", "miserable");
    LinkedList<Task> tasks;
    int MAX = 10; // 超过max，暂停任务发放

    public Teacher(String name, LinkedList<Task> tasks) {
        super(name); // 设置线程名称
        this.name = name;
        this.tasks = tasks;
    }

    public void arrangeTask() throws InterruptedException{
        while (true) {
            synchronized (tasks) {
                if (tasks.size() < MAX) {
                    Task task = new Task(getWord(), new Random().nextInt(3) + 1);
                    System.out.println(name + " remind task: " + task.toString());
                    tasks.addLast(task);
                    tasks.notifyAll(); // 将所有的任务线程唤醒
                } else {
                    // 若任务数超过task的最大值，tc进入等待
                    System.out.println("thread " + name + " start wait.");
                    tasks.wait();
                    System.out.println("thread " + name + " end wait.");
                }
            }
        }
    }

    private String getWord() {
        return words.get(new Random().nextInt(words.size()));
    }

    @Override
    public void run() {
        try {
            arrangeTask();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
