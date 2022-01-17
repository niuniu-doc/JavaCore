package com.multiThread.imooc.test03;

public class TestClient {
    public static void main(String[] args) throws InterruptedException{
        Visiable visiable = new Visiable();
        Thread thread = new Thread(visiable, "test");
        thread.start();

        Thread.sleep(500);// wait for thread started
        visiable.flag = true; // update flag
        System.out.println("flag is true, waiting for print");
        Thread.sleep(1000); // wait for flag update
        System.out.println("slept 1s, I guess nothing print. ");
    }
}
