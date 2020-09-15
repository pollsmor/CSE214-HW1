package cse214hw1;

import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class ArrayQueue<T> implements Queue<T> {
    T[] a;
    int size, start, end; // default to 0

    public ArrayQueue() {
        a = (T[])new Object[20]; // default size
    }

    //Includes null and visibly separates two sides of array
    @SuppressWarnings("StringConcatenationInLoop")
    @Override
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

        start = 0;
        end = outputIdx - 1; // -1 because for loop adds an extra one
        a = output;
    }

    @Override
    public void add(T t) { // copypasted from Deque's addLast
        size++;

        if (a[0] == null && start == 0) a[0] = t; // empty array

        else if ((end + 1) % a.length == start) { // list is full, resize
            resize();
            a[end + 1] = t;
            end++;
        }

        else { // default case: just add to back
            a[(end + 1) % a.length] = t;
            end = (end + 1) % a.length;
        }
    }

    @Override
    public T remove() { // copypasted from Deque's removeFirst
        if (size == 0)
            throw new NoSuchElementException("Empty list.");

        size--;
        T temp = a[start]; // need to return this as per definition
        a[start] = null;
        start++;
        if (start == a.length) start = 0; // don't go out of bounds

        if (size == 0) { // just in case all elements get removed
            start = 0;
            end = 0;
        }

        return temp;
    }

    @Override
    public T peek() {
        if (a.length == 0)
            throw new NoSuchElementException("Empty list.");

        return a[start]; // return head of queue
    }
}
