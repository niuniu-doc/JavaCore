package com.algorim;

public class Step {
    public static void main(String[] args) {
        System.out.println(step(40));
        System.out.println(loopStep(40));
    }
    /**
     * 上台阶
     * 1. 递归
     *  只有一个台阶的时候只有一种走法，有两个台阶的时候有2种走法  1+1 | 2
     *  有3个台阶的时候，1个台阶的走法 + 一次两个台阶
     *                2个台阶的走法 + 一次一个台阶
     *                即： f(1) + f(2)
     *  有4个台阶的时候，2个台阶的走法 + 一次两个台阶
     *                3个台阶的走法 + 一次一个台阶
     *                即：f(2) + f(3)
     *                ...
     *                f(n) = f(n-1) + f(n-2)
     */
    public static int step(int n) {
        if (n==1 || n==2) return n;
        return step(n-1) + step(n-2);
    }

    public static int loopStep(int n) {
        if (n==1 || n==2) return n;
        int one = 1; // 定义走到第一阶的方法
        int two = 2; // 定义走到第二阶的方法
        int sum = 0; // 定义方法总数
        for ( int i = 3; i <= n; i++) {
            sum = one + two; // 对于n=4 sum=f(3) + f(2)，此时第一阶是 2、第二阶是 3
            one = two; // 改变变量的值，对于n=5，第一阶的值是 3，第二阶是 4
            two = sum;
        }
        return sum;
    }
}
