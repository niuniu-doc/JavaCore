package com.ds.arrays.DynamicArray;

import java.util.Arrays;

/**
 * 可动态扩容的数组
 */
public class DynamicArray<E> {
    private int size;
    private int capacity;
    private E[] data;

    /**
     * 无参构造
     */
    public DynamicArray() {
        this(10);
    }

    public DynamicArray(int capacity) {
        data = (E[]) new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    /**
     * 获取元素个数
     */
    public int getSize() {
        return this.size;
    }

    /**
     * 获取数组容量
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * 判断数组是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 添加元素
     */
    public void add(int index, E e) throws Exception{
        if (index < 0 || index > size) {
            throw new Exception("index should be between 0 and size. size = " + size);
        }
        if (size == capacity) ensureCapacity(this.capacity);
        for (int i = size; i > index; i--) {
            data[i] = data[i-1];
        }
        data[index] = e;
        size++;
    }

    public void addFirst(E e) throws Exception { add(0, e);}
    public void addLast(E e) throws Exception { add(size, e);}

    /**
     * 查看是否包含某元素
     * @param e
     */
    public boolean contains(E e) {
        for (int i=0; i<size; i++) {
            if (data[i].equals(e)) return true;
        }
        return false;
    }

    /**
     * 若元素包含在数组中、返回元素下标
     * @param e
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) return i;
        }
        return -1;
    }

    public E get(int index) throws Exception {
        if (index <0 || index >= size) {
            throw new Exception("illegal index.");
        }
        return data[index];
    }

    public void set(int index, E e) throws Exception{
        if (index <0 || index >= size) {
            throw new Exception("illegal index.");
        }
        data[index] = e;
    }

    public void remove(int index) throws Exception{
        if (index <0 || index >= size) {
            throw new Exception("illegal index.");
        }
        for (int i = index+1; i < size ; i++) {
            data[i-1] = data[i];
        }
        data[size] = null;
        size--;

        if (size < this.capacity / 2)
            ensureCapacity(this.capacity / 2);
    }

    public void removeFirst() throws Exception { remove(0);}
    public void removeLast() throws Exception { remove(size);}

    public void removeElement(E e) throws Exception{
        int index = find(e);
        if (index != -1)
            remove(index);
    }


    @Override
    public String toString() {
        return "DynamicArray{" +
                "size=" + size +
                ", capacity=" + capacity +
                ", data=" + Arrays.toString(data) +
                '}';
    }

    private void ensureCapacity(int newCap) {
        this.capacity = newCap;
        E[] newData = (E[])new Object[this.capacity];
        newData = Arrays.copyOf(data, this.size);
        data = newData;
    }
}
