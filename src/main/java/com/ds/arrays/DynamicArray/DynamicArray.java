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
        if (size == capacity) ensureCapacity(2*capacity);
        for (int i = size-1; i >= index; i--) {
            data[i+1] = data[i];
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

    public E getLast() throws Exception{
        return get(size-1);
    }

    public E getFirst() throws Exception {
        return get(0);
    }

    public void set(int index, E e) throws Exception{
        if (index <0 || index >= size) {
            throw new Exception("illegal index.");
        }
        data[index] = e;
    }

    public E remove(int index) throws Exception{
        if (index <0 || index >= size) {
            throw new Exception("illegal index.");
        }
        E ret = data[index];
        for (int i = index+1; i < size ; i++) {
            data[i-1] = data[i];
        }
        size--;
        data[index] = null;

        if (size < this.capacity / 4 && data.length / 2 != 0)
            ensureCapacity(this.capacity / 2);
        return ret;
    }

    public E removeFirst() throws Exception { return remove(0);}
    public E removeLast() throws Exception { return remove(size-1);}

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
        E[] newData = (E[])new Object[newCap];
        //newData = Arrays.copyOf(data, this.size);
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
