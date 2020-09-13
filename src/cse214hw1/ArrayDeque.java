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

        start = 0;
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
        size++;

        if (a[0] == null) a[0] = t; // empty array

        else if (end + 1 == start || end + 1 == a.length) { // list is full, resize
            resize();
            a[end + 1] = t;
            end++;
        }

        else { // default case: just add to back
            a[end + 1] = t;
            end++;
        }
    }

    @Override
    public T removeFirst() {
        if (size == 0)
            throw new NoSuchElementException("Empty list.");

        T temp = a[start]; // need to return this as per definition
        a[start] = null;
        start++;
        if (start == a.length) start = 0; // don't go out of bounds

        return temp;
    }

    @Override
    public T removeLast() {
        if (size == 0)
            throw new NoSuchElementException("Empty list.");

        T temp = a[end]; // need to return this as per definition
        a[end] = null;
        end--;
        if (end == -1) end = a.length -1; // don't go out of bounds

        return temp;
    }

    public static <T> ArrayDeque<T> of (T... args) {
        ArrayDeque<T> output = new ArrayDeque<>();

        for (T el : args) {
            output.addLast(el);
        }

        return output;
    }
}
