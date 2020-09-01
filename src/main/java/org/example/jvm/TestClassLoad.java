package org.example.jvm;

public class TestClassLoad {
    private static int a;
    private static final int b = 2;
    static class Sun extends Parent{
        {
            a = 1;
            System.out.println("sun: " + a); // a=1
        }

        Parent p = new Parent();
        public Sun() {
            a = 5;
            System.out.println("sun - con: " + a); // 5
        }

        {
            a = 3;
            System.out.println("sun - 2: " + a); // 3
        }
    }

    static class Parent {
        {
            a = 2;
            System.out.println("p: " + a); // a=2
        }

        public Parent() {
            System.out.println("p - con: " + a); // 2
            a = 4;
            System.out.println("p - con: " + a); // 4
        }
    }


    public static void main(String[] args) {
        {
            a = 1;
        }

        System.out.println("main: " + a); // a=0
        Sun sun = new Sun();
    }
}
