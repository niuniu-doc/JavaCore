package com.jvm;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class ReferenceQueueDemo {
    public static void main(String[] args) throws Exception{
        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();

        WeakReference<Object> reference = new WeakReference<>(o1, referenceQueue);
        System.out.println(o1);
        System.out.println(reference.get());
        System.out.println(referenceQueue.poll());

        System.out.println("===========");
        o1 = null;
        System.gc();
        Thread.sleep(500);

        System.out.println(o1);
        System.out.println(reference.get());
        System.out.println(referenceQueue.poll()); // GC回收之前放入队列中
    }
}
