package com.vincent.algorithm.sortingadvance;

import com.vincent.algorithm.sortingbasic.InsertionSort;
import com.vincent.algorithm.sortingbasic.SortTestHelper;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序，主要在于partition方法，定一个基准值
 * Created by vincent on 2018/1/2.
 */
public class QuickSort {
    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        //优化1，在数组长度很小时使用插入排序
        if (r - l < 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }
        //此时p位置的元素已经是排好续的
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    private static int partition(Comparable[] arr, int l, int r) {
        int j = l;
        //基准值，随机取一位，避免有序的情况退化成O(n^2)，后面所有的元素都和v比较，如果比v大就放在[j+1，i)区间内，如果比v小，则不需要交换，只需要移动j的位置
        int range = new Random().nextInt(r - l + 1) + 1;
        swap(arr, r, range);
        Comparable v = arr[l];
        for (int i = l + 1; i <= r; i++) {
            if (v.compareTo(arr[i]) > 0) {
                //这里先移动j的索引，即当前比基准值v大的值放在j的后面（因为比v大的值放在[j+1, r]区间），这里的遍历值比v小，所以需要和比v大的[j+1,i]区间的第一元素交换，再向后移动j
                j++;
                swap(arr, j, i);
            }
        }
        //最后交换j和基准位置v的值
        swap(arr, l, j);
        return j;
    }

    private static void swap(Comparable[] arr, int j, int i) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        //此处测试得到快速排序比arrays自带的优化后的归并排序还要快, 但是针对有序的数组排序和优化后的归并排序差距很大，最差的情况退化为O(n^2),
        // 因为每次都不是均分，有可能出现左子树全是空的
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateNearlyOrderedArray(N, 100);
        Integer[] arr1 = new Integer[arr.length];
        System.arraycopy(arr, 0, arr1, 0, arr1.length);
        SortTestHelper.testSort(QuickSort.class, arr);
        //SortTestHelper.printArray(arr);
        long start = System.currentTimeMillis();
        Arrays.sort(arr1);
        long end = System.currentTimeMillis();
        System.out.println("Arrays :" + (end - start) + "ms");
    }
}
