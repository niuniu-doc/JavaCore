package com.ds.stack;

public interface Stack<E> {
    boolean isEmpty();
    int getSize();
    void push(E e) throws Exception;
    E pop() throws Exception;
    E peek() throws Exception;
}
