package com.ds.arrays;

import java.util.Arrays;

public class DynamicArray2<E> {
    private E[] data;
    private int size;


    public DynamicArray2(int capacity) {
        data = (E[])new Object[capacity];
        this.size = 0;
    }

    public DynamicArray2() { this(10); }

    // 获取数组大小
    public int getSize() {
        return this.size;
    }

    // 获取数组容量大小
    public int getCapacity() {
        return data.length;
    }

    // add
    public void add(int index, E e) {
        if (index < 0 || index > size)
            System.out.println("index not allow.");
        // 数组满
        if (size == getCapacity()) resize(2 * getCapacity());

        for (int i = size; i > index ; i--) {
            data[i] = data[i-1];
        }
        data[index] = e;
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    // 移除元素
    public E remove(int index) {
        if (index <0 || index >= size) {
            System.out.println("index is not allow. ");
        }
        E ret = data[index];
        for (int i = index; i < size; i++) {
            data[i] = data[i+1];
        }
        size--;
        data[size]=null;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);

        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size-1);
    }


    // 扩容 / 缩容
    public void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < getSize(); i++) {
            newData[i] = data[i];
        }
        this.data = newData;
    }

    @Override
    public String toString() {
        return "DynamicArray2{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                ", cap=" + data.length +
                '}';
    }

    public static void main(String[] args) {
        DynamicArray2 array = new DynamicArray2();
        array.addFirst(0);
        array.addFirst(1);
        array.addFirst(2);
        array.addLast(4);
        array.addLast(5);
        array.addLast(5);
        array.addLast(5);
        array.addLast(5);
        array.addLast(5);
        array.addLast(5);
        array.addLast(5);
        array.addLast(5);
        array.removeFirst();
        array.removeFirst();
        array.removeFirst();
        System.out.println(array);
        array.removeLast();
        array.removeLast();
        System.out.println(array);
    }
}
