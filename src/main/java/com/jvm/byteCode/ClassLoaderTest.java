package com.jvm.byteCode;

public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);

        ClassLoader bootClassLoader = extClassLoader.getParent();
        System.out.println(bootClassLoader); // null, 无法获取到引导类加载器

        // 用户自定义类，默认使用 系统类加载器加载
        ClassLoader cl = ClassLoaderTest.class.getClassLoader();
        System.out.println(cl);

        ClassLoader cl2 = String.class.getClassLoader();
        System.out.println(cl2); // null，说明系统核心类是使用 bootstrapClassLoader 加载的
    }
}
