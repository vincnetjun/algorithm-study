package com.vincent.algorithm.sortingbasic;

/**
 * 插入排序，思想类似于整理卡牌，第二张开始，如果比前一张纸牌小，就往前插入，直至第一张，否则结束，继续下一张
 * 针对本身就相对有序，只是部分地方无序时效率将会很高，因为插入排序有机会提前结束循环，而选择排序则是无法提前结束的
 * Created by vincent on 2017/12/31.
 */
public class InsertionSort {
    public static void sort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //第二种写法
/*            for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                //交换过多，导致性能消耗
                swap(arr, j, j - 1);
            }*/
            //优化，不采用交换，而使用赋值的方式，即如果比前一位小，就把前一位的值赋值到当前位置，直至第一个元素
            Comparable e = arr[i];
            int j;
            for (j = i; j > 0 && arr[j-1].compareTo(e) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }

    /**
     * 新增对数组[l..r]区间内元素排序的方法
     * @param arr 数组
     * @param l 左边界
     * @param r 右边界
     */
    public static void sort(Comparable[] arr, int l, int r) {
        assert l >= 0 && l <= r && r < arr.length;
        for (int i = l+1; i < r+1; i++) {
            Comparable e = arr[i];
            int j;
            for (j = i; j > 0 && arr[j-1].compareTo(e) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }

    private static void swap(Comparable[] arr, int j, int i) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }




    public static void main(String[] args) {
        int length = 10000;
        Integer[] array = SortTestHelper.generateRandomArray(length, 15,length);
        Integer[] array1 = new Integer[array.length];
        System.arraycopy(array, 0, array1, 0, array.length);
        Integer[] array2 = new Integer[array.length];
        System.arraycopy(array, 0, array2, 0, array.length);
        SortTestHelper.testSort(InsertionSort.class, array);
        SortTestHelper.printArray(array);
        SortTestHelper.testSort(SelectionSort4Object.class, array1);
        SortTestHelper.printArray(array1);
        SortTestHelper.testSort(BubbleSort.class, array2);
        SortTestHelper.printArray(array2);


    }
}
