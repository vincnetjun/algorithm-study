package com.vincent.algorithm.sortingbasic;

/**
 * Created by Vincent on 2018/1/1.
 */
public class BubbleSort {
    public static void sort(Comparable[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                //从i+1开始寻找最小值
                if (arr[j].compareTo(arr[i])<0){
                    //如果j的值比当前位置i的值小交换
                    Comparable temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        BubbleSort.sort(arr);
        for (Integer integer : arr) {
            System.out.println(integer);
        }

    }
}
