package com.ds.arrays.DynamicArray;

public class TestDynamic {
    public static void main(String[] args) throws Exception{
        DynamicArray array = new DynamicArray();
        array.addFirst(1);
        array.addFirst(2);
        array.addFirst(3);
        array.addLast(4);
        System.out.println(array);

        array.remove(1);
        System.out.println(array);
    }
}
