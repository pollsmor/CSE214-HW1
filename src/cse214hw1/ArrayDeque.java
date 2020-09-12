package cse214hw1;

import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class ArrayDeque<T> implements Deque<T> {
    T[] a;
    int size, start, end; // default to 0

    public ArrayDeque() {
        a = (T[])new Object[20]; // default size of array
    }

    public ArrayDeque(int size) {
        if (size <= 0) size = 1; // edge case with bad input

        a = (T[])new Object[size];
    }

    //Includes null and visibly separates two sides of array
    @SuppressWarnings("StringConcatenationInLoop")
    public String toString() {
        String output = "{";

        for (int i = start; i < a.length; i++)
            output += a[i] + "(" + i + ")" + " ";

        output += "} / {";

        //Would never get run if end > start (normal list, start = 0)
        for (int i = 0; i < start; i++)
            output += a[i] + "(" + i + ")" + " ";

        output += "}";

        return output;
    }

    private void resize() {
        T[] output = (T[])new Object[a.length * 2];
        int outputIdx = 0;

        for (int i = start; i < a.length; i++) {
            output[outputIdx] = a[i];
            outputIdx++;
        }

        // Only runs if start > end
        for (int i = 0; i < start; i++) {
            output[outputIdx] = a[i];
            outputIdx++;
        }

        end = outputIdx - 1; // -1 because for loop adds an extra one
        a = output;
    }

    //@Override
    public void addFirst(T t) {
        size++;

        if (a[0] == null) a[0] = t; // empty array

        else if (start == 0) { // start has to be moved to end of list
            a[a.length - 1] = t;
            start = a.length - 1; // end can remain at 0 or whatever it is
        }

        else if (start - 1 <= end) { // list is full, resize
            resize();
            a[a.length - 1] = t;
            start = a.length - 1;
        }

        else { // default case: just add in front
            a[start - 1] = t;
            start--;
        }
    }

    @Override
    public void addLast(T t) {

    }

    @Override
    public T removeFirst() {
        return a[0];
    }

    @Override
    public T removeLast() {
        return a[0];
    }
}
