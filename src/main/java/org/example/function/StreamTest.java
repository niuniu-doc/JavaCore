package org.example.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("张无忌", "周芷若", "赵敏", "张强", "张三丰"));
        List<String> res = list.stream().filter(n -> n.contains("张") && n.length()==3).collect(Collectors.toList());
        System.out.println(res);
    }
}
