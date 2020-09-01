package org.example.annotation;

public class Test {

    static class Parent {
        public void a () {
            System.out.println("parent");
        }
    }

    static class Child extends Parent {
        @Override
        public void a() {
            System.out.println("child");
        }
    }

    public static void main(String[] args) {
        Child child = new Child();
        child.a();

    }
}
