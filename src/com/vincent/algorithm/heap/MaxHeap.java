package com.vincent.algorithm.heap;

import com.vincent.algorithm.sortingbasic.SortTestHelper;

/**
 * Created by razrh on 2018/1/13.
 * 使用数组构造最大堆
 * 最大堆：是完全二叉树（除最下面一层是个满二叉树，并当前节点的值都比子节点的值要大，最下面一层的节点都在左侧）
 * 若第0层（顶）标记为1，左子节点为2，右子节点为3，那么满足规律(假设当前标记为i)左孩子为2*i,右孩子则为2*i+1,父节点为i/2（自动向下取整了）
 * 完全二叉树的第一个非叶子节点索引位置是n/2，其中n为长度
 */
public class MaxHeap<Item extends Comparable> {
    protected Item[] data;
    protected int count;
    protected int capacity;

    /**
     * 构造一个空的数组，长度为capacity+1，因为第0个位置留空了，初始化当前数量count为0
     *
     * @param capacity
     */
    public MaxHeap(int capacity) {
        this.data = (Item[]) new Comparable[capacity + 1];
        this.count = 0;
        this.capacity = capacity;
    }

    /**
     * 重新写一个构造函数构造，初始化的时候就排序以满足最大堆的定义
     * @param arr
     * @param n
     */
    public MaxHeap(Comparable[] arr, int n) {
        this.data = (Item[]) new Comparable[n + 1];
        this.count = n;
        this.capacity = n;
        System.arraycopy(arr, 0, this.data, 1, count);

        //从第一个非叶子节点开始使用shiftDown操作
        for (int i = count / 2; i >= 1; i--) {
            shiftDown(i);
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 插入新元素
     *
     * @param item
     */
    public void insert(Item item) {
        assert count + 1 <= capacity;
        data[count + 1] = item;
        count++;
        //重新排序以满足最大堆的定义
        shiftUp(count);
    }

    /**
     * 当比父节点值data[k /2]大的时候交换
     *
     * @param k
     */
    private void shiftUp(int k) {
        //k必须大于1,位于顶部的时候已经不需要shiftUp操作了
        if (k > 1 && data[k / 2].compareTo(data[k]) < 0) {
            swap(k, k / 2);
            k /= 2;
        }
    }

    private void swap(int k, int i) {
        Item temp = data[k];
        data[k] = data[i];
        data[i] = temp;
    }

    /**
     * 取出顶部的元素
     *
     * @return
     */
    public Item extractMax() {
        assert count > 0;
        Item item = data[1];
        //先将最后一个元素与第一个元素交换
        swap(1, count);
        //记得调整数量大小
        count--;
        //重新排序以满足最大堆的定义
        shiftDown(1);
        return item;

    }

    /**
     * 向下重新排序，以保证此树满足最大堆的定义
     *
     * @param k
     */
    private void shiftDown(int k) {
        //若子节点存在的时候，与子节点中的最大值交换
        while (2 * k <= count) {
            //左子节点的索引位置
            int j = 2 * k;
            //当右子节点存在，寻找出左右子节点的最大值的索引
            if (j + 1 <= count && data[j + 1].compareTo(data[j]) > 0) {
                j++;
            }
            //当比左右子节点都要大的时候就推出循环
            if (data[k].compareTo(data[j]) >= 0) {
                break;
            }
            //交换当前节点与子节点中最大值
            swap(k, j);
            //重新记录当前的位置
            k = j;
        }
    }

    public static void main(String[] args) {
        int max = 100;
        int size = 31;
        MaxHeap maxHeap = new MaxHeap(size);
        for (int i = 0; i < size; i++) {
            maxHeap.insert(new Integer((int) (Math.random() * max)));
        }
        for (int i = 0; i < size; i++) {
            System.out.print(maxHeap.data[i] + " ");
        }
        System.out.println();
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = (Integer) maxHeap.extractMax();
            System.out.print(array[i] + " ");
        }
        System.out.println("");

    }
}
