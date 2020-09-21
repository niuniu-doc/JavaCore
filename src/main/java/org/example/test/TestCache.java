package org.example.test;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.in;

public class TestCache {
    public static void main(String[] args) {
        int n = 10000;
        int[][] arr = new int[n][n];
        long start = currentTimeMillis();
        for (int i = 0; i<n; i++) {
            for (int j=0; j<n; j++) {
                arr[i][j] = 1;
            }
        }
        System.out.println("time: " + (currentTimeMillis() - start) + "ms");

        try {
            Thread.sleep(100);
        } catch (Exception e) {
            // ignore
        }
        long start1 = currentTimeMillis();
        for (int i = 0; i<n; i++) {
            for (int j=0; j<n; j++) {
                arr[j][i] = 1;
            }
        }
        System.out.println("time: " + (currentTimeMillis() - start1) + "ms");
    }
}
