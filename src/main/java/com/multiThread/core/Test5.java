package com.multiThread.core;

public class Test5 {
    public static void main(String[] args) {
        ThreadB t = new ThreadB();
        System.out.println("begin: " + t.getName() + ", isAlive: " + t.isAlive());
        t.start();
        System.out.println("end: " + t.getName() + ", isAlive: " + t.isAlive());
    }
}

class ThreadB extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("name = " + this.getName() + ", isAlive = " + this.isAlive());
    }
}
