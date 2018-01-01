package com.vincent.algorithm.sortingbasic;

/**
 * 希尔排序，本质上就是插入排序，不过进行了优化，排序时先进行分组，增量决定了算法的时间，此处采用3×n+1构建1, 4, 13, 40, 121, 364, 1093...的数列
 * Created by vincent on 2017/12/31.
 */
public class ShellSort {
    public static void sort(Comparable[] arr) {
        int n = arr.length;

        // 计算 increment sequence: 1, 4, 13, 40, 121, 364, 1093...
        int h = 1;
        while (h < n / 3) h = 3 * h + 1;

        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < n; i++) {
                // 对 arr[i], arr[i-h], arr[i-2*h], arr[i-3*h]... 使用插入排序
                Comparable e = arr[i];
                int j = i;
                for (; j >= h && e.compareTo(arr[j - h]) < 0; j -= h)
                    arr[j] = arr[j - h];
                arr[j] = e;
            }

            h /= 3;
        }

    }


    public static void main(String[] args) {
        int len = 100000;
        Integer[] array = SortTestHelper.generateRandomArray(len, 0, 10000);
        SortTestHelper.testSort(ShellSort.class, array);
        SortTestHelper.printArray(array);
    }
}
