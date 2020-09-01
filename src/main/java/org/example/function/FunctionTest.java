package org.example.function;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionTest {
    public static void change(String s, Function<String, Integer> function) {
        Integer in = function.apply(s);
        System.out.println(in);
    }

    public static void main(String[] args) {
        String s = "赵,1234";
//        change(s, Integer::parseInt);
//        change2(s, Integer::parseInt, i -> (i+10)+"");
//        change3(s, p -> p.split(",")[1], Integer::parseInt, i -> i+10);

        testForEach();
        testMap();
        testMax();
        testNoneMatch();
        testPeek();
        testReduce();
        testSkip();
        testLimit();
        testFunc();
    }

    public static void testFunc() {
        System.out.println("======= testFunc ==========");
        Function<Integer, Integer> func = e -> {
            return e + 5;
        };
        Function<Integer, Integer> func2 = e -> {return e * 2; };
        int res = cacl(2, func);
        System.out.println(res);
        System.out.println(func.andThen(func2).apply(1)); // 先执行 func, 然后执行 func2
        System.out.println(func.compose(func2).apply(1)); // 先执行 func2, 再执行 func
    }

    public static int cacl(int res, Function<Integer, Integer> func) {
        return func.apply(res);
    }

    public static void change2(String s, Function<String, Integer> f1, Function<Integer, String> f2) {
        String res = f1.andThen(f2).apply(s);
        System.out.println(res);
    }

    public static void change3(String s, Function<String, String> f1, Function<String, Integer> f2, Function<Integer, Integer> f3) {
        int r = f1.andThen(f2).andThen(f3).apply(s);
        System.out.println(r);
    }

    public static void testForEach() {
        int[] a = {89, 91, 96, 93, 92};
        Arrays.stream(a).filter(v -> v > 90).forEach(System.out::println);
        System.out.println("=====");
        Arrays.stream(a).filter(v -> v > 90).forEachOrdered(System.out::println);
    }

    public static void testMap() {
        String[] a = {"1", "2", "3", "6"};
        int[] s = Arrays.stream(a).mapToInt(Integer::parseInt).toArray();

        System.out.println(Arrays.asList(s));
    }

    public static void testMax() {
       int[] a = {1, 3, 5, 10};
       int max = Arrays.stream(a).max().getAsInt();
        System.out.println(max);
    }

    public static void testNoneMatch() {
        int[] a = {1, 3, 5, 10};
        boolean match = Arrays.stream(a).noneMatch(s -> s == 3);
        boolean match2 = Arrays.stream(a).noneMatch(s -> s == 4);
        System.out.println(match);
        System.out.println(match2);
    }

    public static void testPeek() {
        List list = Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
        System.out.println(list);
    }

    public static void testReduce() {
        int sum = Stream.of(1, 2, 3, 4, 10)
                .reduce(0, (total, cur) -> total + cur);
//                .reduce(0, Integer::sum);
        System.out.println(sum);
    }

    public static void testSkip() {
        System.out.println("======= test skip ====== ");
        Stream.of("one", "two", "three", "four")
                .skip(1)
                .forEach(System.out::println);
    }

    public static void testLimit() {
        System.out.println("======= test limit ====== ");
        Stream.of("one", "two", "three", "four")
                .skip(1).limit(2)
                .forEach(System.out::println);
    }
}


