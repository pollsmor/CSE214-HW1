package cse214hw1;

import java.util.Arrays;

public class Tests {
    public static void main(String[] args) {
        System.out.println("Rotate tests");
        int[] a = {1, 2, 3, 4, 5};
        ArrayUtils.rotate(a, 1);

        int[] b = {1, 2, 3, 4, 5};
        ArrayUtils.rotate(b, 2);

        char[] c = {'a', 'b', 'c', 'd', 'e'};
        ArrayUtils.rotate(c, 2);

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));

        System.out.println("Merge test");
        System.out.println(Arrays.toString(ArrayUtils.merge(a, b)));

        System.out.println("Deque test");
        Deque<String> deque = new ArrayDeque<>(5);
        System.out.println(deque);
        deque.addFirst("1");
        deque.addFirst("2");
        deque.addFirst("3");
        deque.addFirst("4");
        deque.addFirst("5");
        deque.addFirst("6");
        System.out.println(deque);
        deque.removeFirst();
        deque.removeFirst();
        deque.removeFirst();
        deque.removeLast();
        deque.removeLast();
        deque.removeLast();
        System.out.println(deque);
        deque.addFirst("1");
        deque.addLast("2");
        System.out.println(deque);


        Deque<String> deque2 = new ArrayDeque<>(5);
        System.out.println(deque2);
        deque2.addLast("1");
        deque2.addLast("2");
        deque2.addLast("3");
        deque2.addLast("4");
        deque2.addLast("5");
        deque2.addLast("6");
        deque2.addLast("7");
        deque2.addFirst("a");
        deque2.addFirst("b");
        deque2.addFirst("c");
        System.out.println(deque2);

        deque2.removeFirst();
        System.out.println(deque2);
        deque2.removeLast();
        System.out.println(deque2);

        ArrayDeque<Double> test = ArrayDeque.of(2.0, 4.0, 5.25);
        test.addFirst(7.0);
        System.out.println(test);

        System.out.println("Queue test");
        Queue<Character> q = new ArrayQueue<>();
        System.out.println(q);
    }
}
