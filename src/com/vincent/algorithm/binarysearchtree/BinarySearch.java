package com.vincent.algorithm.binarysearchtree;

/**
 * 二分法查找
 * Created by razrh on 2018/1/28.
 */
public class BinarySearch {
    public static int find(Comparable[] arr, Comparable target) {
        int n = arr.length;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            //int mid = (l + r) / 2; 可能存在内存溢出的情况
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid].compareTo(target) < 0) {
                //中间值比target值小，就意味着target应该在[mid+1,r]区间内
                l = mid + 1;
            } else {
                //中间值比target值大，就意味着target应该在[l,mid-1]区间内
                r = mid - 1;
            }
        }
        //没有找到直接返回-1
        return -1;
    }

    /**
     * 递归的实现
     *
     * @param arr
     * @param target
     * @return
     */
    public static int find2(Comparable[] arr, int l, int r, Comparable target) {
        int n = arr.length;
        int mid = l + (r - l) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid].compareTo(target) < 0) {
            //中间值比target值小，就意味着target应该在[mid+1,r]区间内
            return find2(arr, mid + 1, r, target);
        } else {
            //中间值比target值大，就意味着target应该在[l,mid-1]区间内
            return find2(arr, l, mid - 1, target);
        }
    }

}
