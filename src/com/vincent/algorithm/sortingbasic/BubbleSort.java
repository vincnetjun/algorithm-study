package com.vincent.algorithm.sortingbasic;

/**
 * 冒泡排序
 * Created by vincent on 2017/12/31.
 */
public class BubbleSort {
    public static void sort(Comparable[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i].compareTo(arr[j] )>0){
                    swap(arr,i,j);
                }
            }
        }
/*        int n = arr.length;
        boolean swapped = false;
        //int newn; // 理论上,可以使用newn进行优化,但实际优化效果较差

        do{
            swapped = false;
            //newn = 0;
            for( int i = 1 ; i < n ; i ++ )
                if( arr[i-1].compareTo(arr[i]) > 0 ){
                    swap( arr , i-1 , i );
                    swapped = true;

                    // 可以记录最后一次的交换位置,在此之后的元素在下一轮扫描中均不考虑
                    // 实际优化效果较差,因为引入了newn这个新的变量
                    //newn = n;
                }

            //n = newn;

            // 优化, 每一趟Bubble Sort都将最大的元素放在了最后的位置
            // 所以下一次排序, 最后的元素可以不再考虑
            // 理论上, newn的优化是这个优化的复杂版本,应该更有效
            // 实测, 使用这种简单优化, 时间性能更好
            n --;
        }while(swapped);*/
    }
    private static void swap(Comparable[] arr, int j, int i) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
