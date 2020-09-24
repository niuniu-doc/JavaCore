package com.ds.stack.ArrayStack;

import com.ds.arrays.DynamicArray.DynamicArray;

public class ArrayStack<E> implements Stack<E> {

    private DynamicArray<E> array;

    public ArrayStack(int capacity) {
        array = new DynamicArray<>(capacity);
    }

    public ArrayStack() {
        array = new DynamicArray<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) throws Exception{
        array.addLast(e);
    }

    @Override
    public E pop() throws Exception{
        return array.removeLast();
    }

    @Override
    public E peek() throws Exception {
        return array.getLast();
    }
}
