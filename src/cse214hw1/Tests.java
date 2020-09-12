package cse214hw1;

import java.util.*;

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
    }
}