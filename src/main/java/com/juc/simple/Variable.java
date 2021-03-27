package com.juc.simple;

public class Variable {
    static int s;
    int i;
    int j;

    // 非静态代码块
    {
        int i=1;
        i++;
        j++;
        s++;
    }

    public void test(int j) {
        j++;
        i++;
        s++;
    }

    public static void main(String[] args) {
        Variable variable = new Variable();
        Variable variable2 = new Variable();
        variable.test(10);
        variable.test(20);
        variable2.test(30);
        System.out.println("var1.i = " + variable.i + ", var1.j = " + variable.j + ", var1.s = " + variable.s);
        System.out.println("var2.i = " + variable2.i + ", var2.j = " + variable2.j + ", var2.s = " + variable2.s);
    }
}
