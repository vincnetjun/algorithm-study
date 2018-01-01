package com.vincent.algorithm.sortingbasic;

/**
 * Created by vincent on 2017/12/31.
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        selectionsort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static void selectionsort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 寻找[i, n)区间里的最小值的索引
            // minIndex最小值的索引
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                //查找最小值的索引
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
