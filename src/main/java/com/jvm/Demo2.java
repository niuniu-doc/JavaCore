package com.jvm;

import java.util.ArrayList;
import java.util.List;

public class Demo2 {
    public static void main(String[] args) throws Exception{
        List<Data> dataList = new ArrayList<Data>();
        for (int i = 0; i < 10000; i++) {
            dataList.add(new Data());
        }
        Thread.sleep(1*60*60*1000);
    }

    static class Data {}
}
