package com.ds.queue.ArrayQueue;

import com.ds.arrays.DynamicArray.DynamicArray;

public class ArrayQueue<E> implements Queue<E> {
    private DynamicArray<E> queue;

    public ArrayQueue(int capacity) {
        this.queue = new DynamicArray(capacity);
    }

    public ArrayQueue() {
        this.queue = new DynamicArray();
    }

    @Override
    public int getSize() {
        return queue.getSize();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int getCapacity() {
        return queue.getCapacity();
    }

    @Override
    public void enqueue(E e) throws Exception{
        queue.addLast(e);
    }

    @Override
    public E dequeue() throws Exception {
        return (E) queue.removeFirst();
    }

    @Override
    public E getFront() throws Exception {
        return (E) queue.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for(int i = 0 ; i < queue.getSize() ; i ++){
            try {
                res.append((E)queue.get(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(i != queue.getSize() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
}
