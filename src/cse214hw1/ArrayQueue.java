package cse214hw1;

import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class ArrayQueue<T> implements Queue<T> {
    T[] a;
    int start, size; // default to 0

    public ArrayQueue() {
        a = (T[])new Object[20]; // default size
    }

    @Override
    public void add(T t) {
        size++;
    }

    @Override
    public T remove() {
        if (a.length == 0)
            throw new NoSuchElementException("Empty list.");

        size--;

        return a[0]; // so it compiles
    }

    @Override
    public T peek() {
        if (a.length == 0)
            throw new NoSuchElementException("Empty list.");

        return a[start]; // return head of queue
    }
}
