package com.vincent.algorithm.heap;

/**
 * Created by razrh on 2018/1/13.
 * 使用数组构造最大堆
 * 最大堆：是完全二叉树（除最下面一层是个满二叉树，并当前节点的值都比子节点的值要大，最下面一层的节点都在左侧）
 * 若第0层（顶）标记为1，左子节点为2，右子节点为3，那么满足规律(假设当前标记为i)左孩子为2*i,右孩子则为2*i+1,父节点为i/2（自动向下取整了）
 */
public class MaxHeap<Item extends Comparable> {
    protected Item[] data;
    protected int count;
    protected int capacity;

    /**
     * 构造一个空的数组，长度为capacity+1，因为第0个位置留空了，初始化当前数量count为0
     * @param capacity
     */
    public MaxHeap(int capacity) {
        this.data = (Item[]) new Comparable[capacity + 1];
        this.count = 0;
        this.capacity = capacity;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 插入新元素
     * @param item
     */
    public void insert(Item item){
        assert count+1 <= capacity;
        data[count + 1] = item;
        count ++;
        //重新排序以满足最大堆的定义
        shiftUp(count);
    }

    /**
     * 当比父节点值大的时候交换
     * @param k
     */
    private void shiftUp(int k) {
        //k必须大于1,位于顶部的时候已经不需要shiftUp操作了
        if( k > 1 && data[k /2].compareTo(data[k]) < 0){
            swap(k, k/2);
            k /= 2;
        }
    }

    private void swap(int k, int i) {
        Item temp = data[k];
        data[k] = data[i];
        data[i] = temp;
    }
}
