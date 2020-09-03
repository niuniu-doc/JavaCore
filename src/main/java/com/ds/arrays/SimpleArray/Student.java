package com.ds.arrays.SimpleArray;

public class Student {
    private String name;
    private int score;
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public static void main(String[] args) throws Exception{
        SimpleArray<Student> students = new SimpleArray<>(3);
        students.addLast(new Student("yun", 90));
        students.addLast(new Student("wen", 80));
        students.addLast(new Student("niu", 20));
        System.out.println(students);
    }
}
