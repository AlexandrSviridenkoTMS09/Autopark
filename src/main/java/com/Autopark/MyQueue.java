package com.Autopark;

import java.util.Arrays;

public class MyQueue<T> {
    private static final int DEFAULT_SIZE = 5;
    private Object[] array;
    private int size;
    private int last;
    private int first;

    public MyQueue() {
        array = new Object[DEFAULT_SIZE];
        size = DEFAULT_SIZE;
        last = -1;
        first = 0;
    }

    public void enqueue(T obj) {
        if (last == size - 1) {
            array = Arrays.copyOf(array, size * 2);
        }

        array[++last] = obj;
    }

    public T dequeue() {
        T element = peek();
        first++;

        return element;
    }

    public T peek() {
        if (first > last) {
            throw new IllegalStateException("Queue is empty");
        }

        return (T) array[first];
    }

    public int size() {
        return last - first + 1;
    }
}
