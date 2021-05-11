package com.multiThread.imooc.test02;

import java.util.LinkedList;

public class TestClient {
    public static void main(String[] args) {
        LinkedList<Task> tasks = new LinkedList<>();

        Teacher wang = new Teacher("wang", tasks);
        wang.start();

        Teacher zhang = new Teacher("zhang", tasks);
        zhang.start();

        Student mei = new Student("mei", tasks);
        mei.start();

        Student zheng = new Student("zheng", tasks);
        zheng.start();
    }
}
