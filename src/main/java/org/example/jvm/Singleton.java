package org.example.jvm;

public class Singleton {
    private Singleton(){};
    private static class LazyHolder {
        static final Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return LazyHolder.instance;
    }

    public static void main(String[] args) {
       Singleton.getInstance();
    }
}
