package com.vincent.algorithm.sortingadvance;

/**
 * 归并排序0（nlogn）级别的排序算法
 * Created by Vincent on 2018/1/1.
 */
public class MergeSort {
    public static void sort(Comparable[] arr) {
        int l = 0;
        int r = arr.length - 1;
        sort(arr, l, r);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r)
            return;

        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(Comparable[] arr, int l, int mid, int r) {
        //aux为复制出来的数组，用于操作ij比较然后回填到原数组arr中
        Comparable[] aux = new Comparable[r - l + 1];
        System.arraycopy(arr, l, aux, 0, aux.length);
        //复制出来的数组分左右两部分（已排好序）,然后左右开始移动i,j比较相对索引出的值，哪个小则哪个放进k对应的位置，k++，同时此值所在的i/j进行移动
        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                //[i,mid]区间已经排完
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                //[mid+1,j]区间已经排完
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) < 0) {
                //[i,mid]区间的值小
                arr[k] = aux[i - l];
                i++;
            } else {
                //[mid+1,j]区间的值小
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        MergeSort.sort(arr);
        for (Integer integer : arr) {
            System.out.print(integer + " ");
        }
        System.out.println();

    }
}
