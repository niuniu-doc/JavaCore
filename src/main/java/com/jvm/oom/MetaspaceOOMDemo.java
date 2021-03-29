package com.jvm.oom;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MetaspaceOOMDemo {
    static class OOMTest {}
    public static void main(String[] args) {
        // -XX:MetaspaceSize=8m -XX:MaxMetaspaceSize=8m
        int i=0;
//        Exception in thread "main" java.lang.OutOfMemoryError: Metaspace
        try {
            while (true) {
                i++;
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OOMTest.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invoke(o, args);
                    }
                });
                enhancer.create();
            }
        } catch (Exception e) {
            System.out.println(i + "次后metaspace发生异常");
            e.printStackTrace();
        }
    }
}
