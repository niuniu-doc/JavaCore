package com.juc.simple;

public class AutoInc {
    public static void main(String[] args) {
        /**
         * 注意局部变量表和操作数栈
         * i++ 栈空间i=1，局部变量表 i=2
         * 栈空间i的值赋值给局部变量表，i被重新写回1
         * j = i++，先赋值，将i的值加载到栈空间，赋值给j，j=1
         * k = i + ++i * i++;
         *  将i压栈，i=2；
         *  ++i，i的局部变量表的值变成3，遇到操作符，将i的值压栈，栈中值为i；
         *  i++, 局部变量表中i的值变成4，先运算 压栈，将栈空间顶部的两个值出栈 3*3=9
         *  将结果写回栈空间，计算k的值，弹出栈顶两个值，计算 2+9 = 11
         */
        int i = 1;
        i = i++;
        int j = i++;
        int k = i + ++i * i++;
        System.out.println( "i = " + i + " , j = " + j + " , k = " + k);
    }
}
