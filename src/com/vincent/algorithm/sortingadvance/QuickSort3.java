package com.vincent.algorithm.sortingadvance;

import com.vincent.algorithm.sortingbasic.InsertionSort;
import com.vincent.algorithm.sortingbasic.SortTestHelper;

import java.util.Arrays;

/**
 * Created by vincent on 2018/1/6.
 */
public class QuickSort3 {
    public QuickSort3() {
    }

    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    /**
     * 三路排序，核心思想是分成三队arr[l+1,lt] < v，arr[lt,i) = v，arr[gt,r] > v
     *
     * @param arr
     * @param l
     * @param r
     */
    private static void sort(Comparable[] arr, int l, int r) {
        //对于小规模的数组使用插入排序
        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }
        //随机选择一个标定值
        swap(arr, l, (int) (Math.random() * (r - l + 1)) + 1);
        Comparable v = arr[l];

        int lt = l; //arr[l+1,lt] < v
        int gt = r + 1; //arr[gt,r] > v
        int i = l + 1; //arr[lt,i) = v
        while (i < gt) {
            //比v小，交换lt+1和i的值，然后向后移动lt,i
            if (arr[i].compareTo(arr[i]) < 0) {
                swap(arr, i, lt + 1);
                lt++;
                i++;
            } else if (arr[i].compareTo(v) > 0) {
                //比v大, 交换gt-1和i位置上的值，gt--，i不需要移动，因为i换过来原来gt-1位置未考察的元素
                swap(arr, i, gt - 1);
                gt--;
            } else {
                //等于V,不需要处理，直接i++
                i++;
            }
        }
        //最后只需要交换lt和标定点l的值
        swap(arr, l, lt);

        lt--;

        sort(arr, l, lt);
        sort(arr, gt, r);
    }

    public static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        //经过测试在10000区间内仍然不是很稳定
        int n = 1000000;
        Integer[] array = SortTestHelper.generateRandomArray(n, 0, 10000);
        SortTestHelper.testSort(QuickSort3.class, array);
        Integer[] arr1 = new Integer[n];
        System.arraycopy(array, 0, arr1, 0, arr1.length);
        long start = System.currentTimeMillis();
        Arrays.sort(arr1);
        long end = System.currentTimeMillis();
        System.out.println("Arrays :" + (end - start) + "ms");
    }
}
