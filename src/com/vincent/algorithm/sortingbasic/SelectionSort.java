package com.vincent.algorithm.sortingbasic;

/**
 * 选择排序
 * 基本思想是寻找[i+1,length]（当前位置下一位开始的）中的最小值，然后与当前索引值交换
 * Created by Vincent on 2018/1/1.
 */
public class SelectionSort {
    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //最小值的索引位置
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                //寻找[i+i, length]中最小值的索引
                if (arr[minIndex].compareTo(arr[j]) > 0) {
                    minIndex = j;
                }
            }
            //将当前值与最小值（[i+1,length]区间）交换
            swap(arr, i, minIndex);
        }
    }

    private static void swap(Comparable[] arr, int i, int j) {
        Comparable t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Integer[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        SelectionSort.sort(arr);
        for (Integer integer : arr) {
            System.out.println(integer);
        }

    }
}
