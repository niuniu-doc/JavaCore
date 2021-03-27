package com.juc.initial;

public class Son extends Father{
    /**
     * 类初始化过程
     *  1. 一个类要创建实例，需要先加载并初始化该类
     *    main方法所在的类要先加载和初始化
     *  2. 一个子类要初始化，先初始化其父类
     *  3. 一个类初始化就是先执行<cinit>方法
     *     <cinit>方法由静态类变量显式赋值和静态代码块组成
     *     从上到下按顺序执行
     *     <cinit>方法只执行一次
     * 实例初始化过程
     *   1. 实例初始化就是执行<init>方法
     *      <init>方法可能重载有多个，有几个构造器就有几个
     *      由非静态变量显式赋值、非静态代码块 和 构造器构成
     *      非静态变量显式赋值 和 非静态代码块 从上到下执行，对应构造器最后执行
     *   2. 每次创建对象、调用的就是对应构造器，执行的是 init 方法
     *   3. init 方法的首行是 super 或 super(参数列表)，即 对应的父类构造器
     * 方法的重写
     *   非静态变量的前边其实有一个默认的对象this
     *   this在构造器或init方法表示的是正在创建的对象，因为这里创建的是son对象
     *   所以调用的是son的test方法
     *   i = test() 执行的是子类重写的方法
     *
     *   1. 哪些方法不能被重写？
     *     静态方法、private等子类不可见方法、final方法
     *   2. 对象的多态性
     *     子类若重写了父类的方法，通过子类调用的一定是子类重写后的方法
     *     非静态方法默认的调用对象时this
     *     this对象在构造器或者说init方法中调用的就是正在执行的对象
     */
    private int i = test();
    private static int j=method();
    static {
        System.out.println(6);
    }
    Son() {
        // super 写或者不写、都一定会调用父类的构造器
        super();
        System.out.println(7);
    }
    {
        System.out.println(8);
    }

    public int test() {
        System.out.println(9);
        return 1;
    }

    public static int method() {
        System.out.println(10);
        return 1;
    }

    public static void main(String[] args) {
        Son son = new Son();
        System.out.println();
        Son son1 = new Son();
    }
}
