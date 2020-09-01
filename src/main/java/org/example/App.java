package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = {"org.example"})
public class App 
{
    public static List<String> filter(String[] arr, Predicate<String> p1, Predicate<String> p2) {
//        List<String> list = new ArrayList<>();
        return Arrays.stream(arr).filter(e -> p1.and(p2).test(e)).collect(Collectors.toList());

//        for (String str : arr) {
//            boolean b = p1.and(p2).test(str);
//            if (b) list.add(str);
//        }
//        return list;
    }
    /**
     * DriverManager
     * @param args
     */

    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);

        ThreadGroup currentGroup =
                Thread.currentThread().getThreadGroup();
        int noThreads = currentGroup.activeCount();
        Thread[] lstThreads = new Thread[noThreads];
        currentGroup.enumerate(lstThreads);
        for (int i = 0; i < noThreads; i++)
            System.out.println("线程号：" + i + " = " + lstThreads[i].getName());


        String[] arr = {"test1, girl", "test2, boy", "test3, girl", "t1, girl"};
        List<String> res = filter(arr, (str) -> str.contains("girl"), (str) -> str.contains("1"));
        System.out.println(res);

        new Thread().start();
        new Thread().run();
    }
}
