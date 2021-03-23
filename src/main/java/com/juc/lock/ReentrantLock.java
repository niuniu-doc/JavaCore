package com.juc.lock;

import java.util.concurrent.locks.Lock;

class Phone implements Runnable{
    public synchronized void SendSms() throws Exception {
        System.out.println(Thread.currentThread().getId() + "\t invoked sendSms.");
        SendEmail();
    }

    public  synchronized void SendEmail() throws Exception {
        System.out.println(Thread.currentThread().getId() + "\t invoked sendEmail....");
    }

    Lock lock = new java.util.concurrent.locks.ReentrantLock();
    @Override
    public void run() {
        get();
    }

    public void get() {
        lock.lock();
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getId() + "\t invoked lock....");
            set();
        } catch (Exception e) {

        } finally {
//            lock.unlock();
            lock.unlock();
        }
    }

    public void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getId() + "\t invoked set....");
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }
}

public class ReentrantLock {


    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(()-> {
            try {
                phone.SendSms();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t1").start();


        new Thread(()-> {
            try {
                phone.SendSms();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t2").start();


        System.out.println();
        System.out.println();
        System.out.println();

        Thread t3 = new Thread(phone);
        Thread t4 = new Thread(phone);
        t3.start();
        t4.start();
    }

}
