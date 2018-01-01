package com.vincent.algorithm.sortingbasic;

/**
 * 选择排序，排序任何和比较的类(实现Comparable接口)
 * Created by vincent on 2017/12/31.
 */
public class SelectionSort4Object {
    public SelectionSort4Object() {
    }

    public static void main(String[] args) {
        Integer[] a = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            System.out.print(' ');
        }
        System.out.println();

        // 测试Double
        Double[] b = {4.4, 3.3, 2.2, 1.1};
        sort(b);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]);
            System.out.print(' ');
        }
        System.out.println();

        // 测试String
        String[] c = {"D", "C", "B", "A"};
        sort(c);
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i]);
            System.out.print(' ');
        }
        System.out.println();

        Student[] d = new Student[4];
        d[0] = new Student("D", 99);
        d[1] = new Student("A", 88);
        d[2] = new Student("B", 99);
        d[3] = new Student("C", 92);
        sort(d);
        for (Student student : d) {
            System.out.print(student.toString());
            System.out.print(' ');
        }

    }

    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //最小值的索引
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                //查找最小值，将索引记录到minIndex
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            //将当前索引值与最小值交换
            swap(arr, i, minIndex);
        }
    }

    private static void swap(Comparable[] arr, int i, int minIndex) {
        Comparable temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }
}
