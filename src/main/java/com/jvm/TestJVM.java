package com.jvm;

/**
 * -XX:NewSize=10485760 -XX:MaxNewSize=10485760
 * -XX:InitialHeapSize=20971520
 * -XX:MaxHeapSize=20971520
 * - XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15
 * -XX:PretenureSizeThreshold=10485760
 * -XX:+UseParNewGC - XX:+UseConcMarkSweepGC
 * -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
 * 初始堆大小：20m,最大堆大小20m，新生代大小10m
 * eden: 8m, from=to=1m
 * 正常年龄大于15晋升，大对象大小大于10m直接放入老年代
 *
 * survivor放不下时、可能会出现部分对象进入老年代，部分对象留在survivor区
 */
public class TestJVM {
    public static void main(String[] args) {
        byte[] array1 = new byte[2*1024*1024]; // 分配2M
        array1 = new byte[2*1024*1024];
        array1 = new byte[2*1024*1024];
        array1 = null;
        /**
         * 连续分配3个2M大小的空间，然后去掉引用，接下来分配128k的空间，此时再分配2m的空间(array3)
         * 空间就不足了(8m-2*3m-128k < 2m)，需要进行一次gc，
         * [ParNew: 6329K->629K(9216K), 0.0019088 secs] 6329K->2679K(19456K)
         * 6m+128k=6227k，加上一百多k的未知对象
         *
         *   eden space 8192K,  55% used
         *   from space 1024K,  61% used
         *   to   space 1024K,   0% used
         *   说明 from占用61%，大概600k，即第一次gc后存活的对象
         *   eden占55%，大概 4505k，4m，是gc后array3在eden区分配的对象
         *   此时进入survivor的600k对象就是1岁，大小超过survivor的50%
         */

        byte[] array2 = new byte[128*1024];
        byte[] array3 = new byte[2*1024*1024];

        /*------------ 以下是案例2 -----------*/
        array3 = new byte[2*1024*1024];
        array3 = new byte[2*1024*1024];
        array3 = new byte[128*1024];
        array3 = null;
        /**
         * 接着分配2个2m的数组，再分配一个128k的，
         */
        byte[] array4 = new byte[2*1024*1024];

    }
}
