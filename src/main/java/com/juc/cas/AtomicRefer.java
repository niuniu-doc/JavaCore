package com.juc.cas;

import java.util.concurrent.atomic.AtomicReference;

class User {
    private String name;
    private int age;

    User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class AtomicRefer {
    public static void main(String[] args) {
        User zhang = new User("zhang", 9);
        User li = new User("li", 10);
        AtomicReference<User> reference = new AtomicReference<>();
        reference.set(zhang);

        System.out.println(reference.compareAndSet(zhang, li) + " " + reference.get().toString());
        System.out.println(reference.compareAndSet(zhang, li) + " " + reference.get().toString());
    }
}
