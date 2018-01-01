package com.vincent.algorithm.sortingbasic;

/**
 * Created by Vincent on 2018/1/1.
 */
public class InsertionSort {
    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            Comparable e = arr[i];
            int j = i;
            for ( ; j > 0 && arr[j-1].compareTo(e) > 0; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = e;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        InsertionSort.sort(arr);
        for (Integer integer : arr) {
            System.out.println(integer);
        }

    }
}
