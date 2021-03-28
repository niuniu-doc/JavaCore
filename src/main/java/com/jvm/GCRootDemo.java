package com.jvm;

/**
 * 1. 虚拟机栈中局部变量
 * 2. 方法区静态属性
 * 3. 方法区常量
 * 4. 本地方法栈引用的对象
 */
public class GCRootDemo {
    private byte[] bytes = new byte[1024*1024*1024];

//    public static GCRootDemo2 t2; // 类静态属性
//    public static final GCRootDemo3 t3 = new GCRootDemo3(); // 常量引用过的对象

    public static void m1() {
        GCRootDemo t1 = new GCRootDemo(); // 虚拟机栈局部变量
        System.gc();
        System.out.println("第一次gc完成");
    }
    public static void main(String[] args) {

    }
}
