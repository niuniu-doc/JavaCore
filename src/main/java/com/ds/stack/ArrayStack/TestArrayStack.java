package com.ds.stack.ArrayStack;

public class TestArrayStack {
    public static void main(String[] args) {
        try {
            ArrayStack<Integer> integerStack = new ArrayStack<>(5);

            integerStack.push(1);
            integerStack.push(2);
            integerStack.push(3);
            integerStack.push(4);

            System.out.println(integerStack.pop());
            System.out.println(integerStack.peek());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
