package com.vincent.algorithm.sortingbasic;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * Created by vincent on 2017/12/31.
 */
public class SortTestHelper {

    /**
     * 生成随机数组
     *
     * @param length 长度
     * @param min    最小值
     * @param max    最大值
     * @return
     */
    public static Integer[] generateRandomArray(int length, int min, int max) {
        assert min <= max;
        Integer[] arr = new Integer[length];
        Random random = new Random();
        int range = max - min + 1;
        for (int i = 0; i < arr.length; i++) {
            int nextInt = random.nextInt(range);
            arr[i] = nextInt + min;
        }
        return arr;
    }

    // 生成一个近乎有序的数组
    // 首先生成一个含有[0...n-1]的完全有序数组, 之后随机交换swapTimes对数据
    // swapTimes定义了数组的无序程度:
    // swapTimes == 0 时, 数组完全有序
    // swapTimes 越大, 数组越趋向于无序
    public static Integer[] generateNearlyOrderedArray(int n, int swapTimes){

        Integer[] arr = new Integer[n];
        for( int i = 0 ; i < n ; i ++ )
            arr[i] = new Integer(i);

        Random random = new Random();
        for( int i = 0 ; i < swapTimes ; i ++ ){
            int a = random.nextInt(n);
            int b = random.nextInt(n);
            int t = arr[a];
            arr[a] = arr[b];
            arr[b] = t;
        }

        return arr;
    }

    /**
     * 打印数组
     *
     * @param arr
     */
    public static void printArray(Comparable[] arr) {
        for (Comparable i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    /**
     * 校验数组是否有序
     * @param arr
     * @return
     */
    public static boolean isSort(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 测试排序性能，打印排序花费时间
     * @param sortClass 排序方法所在类
     * @param arr 排序数组
     */
    public static void testSort(Class sortClass, Comparable[] arr) {
        try {
            //使用反射方式调用方法
            Method method = sortClass.getMethod("sort", new Class[]{Comparable[].class});
            Object[] params = new Object[]{arr};
            long startTime = System.currentTimeMillis();
            method.invoke(null, params);
            long endTime = System.currentTimeMillis();
            assert isSort(arr);
            System.out.println(sortClass.getSimpleName() + " : " + (endTime - startTime) + " ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Integer[] array = SortTestHelper.generateRandomArray(10000, 0, 10000);
        testSort(SelectionSort4Object.class, array);
        SortTestHelper.printArray(array);
    }
}
