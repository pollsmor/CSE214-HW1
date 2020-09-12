package cse214hw1;

public class ArrayUtils {
    private static int mod(int x, int y) {
        int result = x % y;
        if (result < 0) result += y;
        return result;
    }

    /**
     * Rotates the array given array by r number of elements to the left, i.e., for each index i, a[i]
     * moves to a[(i+r) mod a.length].
     * @param a: the input array of <code>int</code>s
     */
    public static void rotate(int[] a, int r) {
        if (a.length <= 1 || (r % a.length) <= 0) return; // edge cases - no reason to run function

        r %= a.length; // in case r is higher than length of array

        for (int i = 0; i < r; i++) { // rotate 1 spot r times
            int temp = a[a.length - 1]; // store last element that will be overwritten
            for (int j = 1; j < a.length; j++) {
                a[a.length - j] = a[a.length - j - 1];
            }

            a[0] = temp; // move stored element to the front
        }
    }

    /**
     * Rotates the array given array by r number of elements to the left, i.e., for each index i, a[i]
     * moves to a[(i+r) mod a.length].
     * @param a: the input array of <code>char</code>s
     */
    public static void rotate(char[] a, int r) {

    }

    /**
     * Creates a merged array c such that c.length = a.length + b.length, and all the elements of b
     * appear in c in the original order, but only after all elements of a (again, in the original
     * order). For example, merge([1,2,3], [4,5]) yields the array [1,2,3,4,5].
     * @param a: the first of the two arrays to be merged
     * @param b: the second of the two arrays to be merged
     * @return c: the merged array
     */
    public static int[] merge(int[] a, int[] b) {
        return a; // temporarily so code compiles
    }
}
