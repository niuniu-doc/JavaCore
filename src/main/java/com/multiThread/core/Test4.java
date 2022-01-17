package com.multiThread.core;

public class Test4 {
    public static void main(String[] args) {
        Thread a = new Thread(()-> Login.doPost("a", "aa"));
        Thread b = new Thread(() -> Login.doPost("b", "bb"));
        a.start();
        b.start();
    }
}

class Login {
    private static String unameRef;
    private static String passRef;
    synchronized public static void doPost(String uname, String pass) {
        unameRef = uname;
        if (uname.equals("a")) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                // ignore.
            }
        }
        passRef = pass;
        System.out.println("uname = " + unameRef + " , pass = " + passRef);
    }

}
