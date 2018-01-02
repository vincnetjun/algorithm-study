package com.vincent.algorithm.sortingadvance;

import com.vincent.algorithm.sortingbasic.InsertionSort;
import com.vincent.algorithm.sortingbasic.SortTestHelper;

import java.util.Arrays;

/**
 * 归并排序，先2分，在排序，自下而上，最终归并完成排序
 * 将arr[l...mid]和arr[mid+1...r]两部分进行归并排序，利用的是复制出来的数组（范围是l,r）
 * Created by vincent on 2018/1/1.
 */
public class MergeSort {

    /**
     * 将arr[l...mid]和arr[mid+1...r]两部分进行归并
     * 简单理解为复制出一副一模一样的牌,牌中左右两堆中，左右两堆中都各自保持有序性，归并过程则将左右两堆逐个比较，
     * 哪个小哪个先放到原来的牌中（自小到大），归并完成则整个副牌[l,r]区间都保证了有序性
     * @param arr
     * @param l
     * @param mid
     * @param r
     */
    private static void merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] aux = new Comparable[r - l + 1];
        System.arraycopy(arr, l, aux, 0, aux.length);

        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            // 原数组与复制出来的数组存在偏移量l
            if (i > mid) {  // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {   // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) < 0) {  // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i - l];
                i++;
            } else {  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

    // 递归使用归并排序,对arr[l...r]的范围进行排序，并且针对有序的情况作了一些优化
    private static void sort(Comparable[] arr, int l, int r) {
        //优化二，数组长度已经很小时采用插入排序
        if (r - l < 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }

        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        //优化一，如果左边数组的最后一个元素小于右边数组的第一个元素，这表明此时数组已经有序，此时就不需要再进行归并排序
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r);
        }
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    public static void main(String[] args) {
        // Merge Sort是我们学习的第一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        // 注意：不要轻易尝试使用SelectionSort, InsertionSort或者BubbleSort处理100万级的数据
        // 否则，你就见识了O(n^2)的算法和O(nlogn)算法的本质差异：）
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateNearlyOrderedArray(N, 15);
        Integer[] arr1 = new Integer[arr.length];
        System.arraycopy(arr, 0, arr1, 0, arr1.length);
        SortTestHelper.testSort(MergeSort.class, arr);
        //SortTestHelper.testSort(ShellSort.class, arr1);
        long start = System.currentTimeMillis();
        Arrays.sort(arr1);
        long end = System.currentTimeMillis();
        System.out.println("Arrays :" + (end - start) + "ms");
    }
}
