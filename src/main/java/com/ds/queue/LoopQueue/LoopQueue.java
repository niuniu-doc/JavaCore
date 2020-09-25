package com.ds.queue.LoopQueue;

import com.ds.queue.Queue;


public class LoopQueue<E> implements Queue<E> {
   private int front, tail;
   private int size;
   private E[] data;

   public LoopQueue(int capacity) {
       data = (E[]) new Object[capacity];
       size = 0;
       front = 0;
       tail = 0;
   }

   public LoopQueue() {
       this(10);
   }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public int getSize() {
        return size;
    }

    public int getCapacity() {
       return data.length;
    }

    @Override
    public void enqueue(E e) throws Exception {
        // 若队列满, 则扩容
        if ((tail+1)%data.length == front)
            resize(getCapacity() * 2);
        data[tail] = e;
        tail = (tail+1)%data.length;
        size++;
    }

    @Override
    public E dequeue() throws Exception {
       // 若队列空、则不能处理
        if (isEmpty())
            System.out.println("queue is empty.");
        E ret = data[front];
        data[front] = null;
        front = (front+1)%data.length;
        size--;
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            System.out.println("queue is empty.");
        return data[front];
    }

    private void resize(int newCapacity) {
       E[] newData = (E[])new Object[newCapacity];
       for (int i=0; i< size; i++) {
           newData[i] = data[i];
       }
       this.data = newData;
       front = 0;
       tail = size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for(int i = front ; i != tail ; i = (i + 1) % data.length){
            res.append(data[i]);
            if((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
}
