package com.multiThread.imooc.test03;

public class ThreadLocalTest {

    public static void main(String[] args) {


        Thread thread1 = new Thread(() -> {
            OperationInfoDTO dto = new OperationInfoDTO(1, "xiaoA");
            OperationInfoRecorder.set(dto);
            System.out.println(OperationInfoRecorder.get());
        }, "thread-A");

        thread1.start();

        new Thread(() -> {
            OperationInfoDTO dto = new OperationInfoDTO(2, "xiaoB");
            OperationInfoRecorder.set(dto);
            System.out.println(OperationInfoRecorder.get());
        }, "thread-B").start();

        System.out.println(OperationInfoRecorder.get());

    }
}
