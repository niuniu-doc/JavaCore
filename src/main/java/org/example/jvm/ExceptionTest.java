package org.example.jvm;

import java.io.IOException;

public class ExceptionTest {
    public static void main(String[] args) {
        try {
            foo();
        } catch (NullPointerException e) {
            System.out.println();
        }
//        catch (IOException e) {
//            System.out.println();
//        }

        try {
            foo();
        } catch (Exception e) {
            System.out.println();
        }
    }
    public static void foo() {

    }
}
