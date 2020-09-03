package com.ds.arrays.basic;

/**
 * Java基础数组操作
 */
public class BasicArray {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        for (int i = 0; i < arr.length; i++) {
            System.out.println("i = " + i + ", val = " + arr[i]);
        }

        for (int i : arr) {
            System.out.println("val : " + i);
        }

        arr[1] = 11;
        for (int i : arr) {
            System.out.println("val : " + i);
        }
    }
}
