package com.juc.simple;

public class ConstPool {
    public static void main(String[] args) {
        String str = "aaa";
        System.out.println(str.split(";")[0]);
        /**
         * str == str.intern() 只有在 java 这个字符串时返回false、其它都是true
         */
        String str1 = new StringBuilder("58").append("tongcheng").toString();
        System.out.println(str1);
        System.out.println(str1.intern());
        System.out.println(str1 == str1.intern());

        System.out.println();

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2);
        System.out.println(str2.intern());
        System.out.println(str2 == str2.intern());
    }
}
