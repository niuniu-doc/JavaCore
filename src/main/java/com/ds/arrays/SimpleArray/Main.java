package com.ds.arrays.SimpleArray;

public class Main {
    public static void main(String[] args) throws Exception{
        SimpleArray<Integer> arr = new SimpleArray<>(20);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.addIndex(1, 100);
        System.out.println(arr);

        arr.removeIndex(2);
        System.out.println(arr);
    }
}
