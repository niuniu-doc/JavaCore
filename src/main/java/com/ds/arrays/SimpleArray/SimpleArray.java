package com.ds.arrays.SimpleArray;

import java.util.Arrays;

public class SimpleArray<E> {
    private int size; // 数组元素个数
    private int capacity; // 数组容量
    private E[] data; // 保存数组数据

    public SimpleArray() {
        this(10);
    }

    public SimpleArray(int capacity) {
        data = (E[])new Object[capacity];
        this.capacity = capacity;
        size = 0;
    }

    /**
     * 获取数组容量
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * 获取元素个数
     */
    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size==0;
    }

    /**
     * add atFirst
     * @return
     */
    public void addFirst(E e) throws Exception{
        addIndex(0, e);
    }

    /**
     * add atLast
     */
    public void addLast(E e) throws Exception {
        addIndex(size, e);
    }

    /**
     * add at index
     */
    public void addIndex(int index, E e) throws Exception {
        if (index < 0 || index > size) {
            throw new Exception("illegal index. max is " + capacity);
        }
        /**
         * 1,2,3 size=3
         * 0 -> 4
         * size = 4
         * data[1] = data[0] // 1
         * data[2] = data[1] // 2
         * data[3] = data[2] // 3
         * data[0] = 4
         */
        for (int i = size-1; i>=index; i--) {
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * getFirst
     */
    public E getFirst() {
        return data[0];
    }

    /**
     * getLast
     */
    public E getLast() {
        return data[size-1];
    }

    public E getIndex(int index) throws Exception{
        if (index < 0 || index >= size) {
            throw new Exception("illegal index. may be between 0 and size " + size);
        }
        return data[index];
    }

    /**
     * 修改index位置的元素
     */
    public void set(int index, E e) throws Exception{
        if (index < 0 || index >= size) {
            throw new Exception("set failed, index is illegal.");
        }
        data[index] = e;
    }

    /**
     * 判断数组中是否包含某个元素
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) return true;
        }
        return false;
    }

    public int find(E e) {
        for (int i=0; i<size; i++) {
            if (data[i].equals(e)) return i;
        }
        return -1;
    }

    /**
     * removeLast
     */
    public E removeLast() throws Exception{
        return removeIndex(size-1);
    }

    /**
     * removeFirst
     * @return
     */
    public E removeFirst() throws Exception{
        return removeIndex(0);
    }

    public E removeIndex(int index) throws Exception{
        if (index < 0 || index >= size) {
            throw new Exception("illegal index.");
        }
        E e = data[index];
        for (int i = index; i < size; i++) {
            data[i] = data[i+1];
        }
        size--;
        return e;
    }

    @Override
    public String toString() {
        return "SimpleArray{" +
                "size=" + size +
                ", capacity=" + capacity +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
