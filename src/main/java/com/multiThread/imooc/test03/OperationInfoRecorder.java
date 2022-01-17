package com.multiThread.imooc.test03;

public final class OperationInfoRecorder {
    private static final ThreadLocal<OperationInfoDTO> threadLocal = new ThreadLocal<>();

    private OperationInfoRecorder() {}

    public static OperationInfoDTO get() {
        return threadLocal.get();
    }

    public static void set(OperationInfoDTO dto) {
         threadLocal.set(dto);
    }

    public static void remove() {
        threadLocal.remove();
    }

}
