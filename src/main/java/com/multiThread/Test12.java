package com.multiThread;

public class Test12 {
    static class SynchronizedObject {
        private String username = "a";
        private String password = "aa";

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        synchronized public void printString(String uname, String pass) {
            try {
                this.username = uname;
                Thread.sleep(10000);
                this.password = pass;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class MyThread extends Thread {
        private SynchronizedObject object;
        public MyThread(SynchronizedObject object) {
            super();
            this.object = object;
        }

        @Override
        public void run() {
            object.printString("b" , "bb");
        }
    }

    public static void main(String[] args) throws Exception{
        SynchronizedObject object = new SynchronizedObject();
        MyThread myThread = new MyThread(object);
        myThread.start();
        Thread.sleep(500);
        myThread.stop();
        System.out.println(object.getUsername() + " " + object.getPassword());
    }
}
