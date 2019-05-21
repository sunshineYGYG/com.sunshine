package com.sunshine.AlgorithmTemplate;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class HeapTemplate2 {

    /***
     * 父节点
     */
    private int parent(int pos) {
        return (pos - 1) / 2;
    }

    /***
     * 左孩子
     */
    private int leftChild(int pos) {
        return pos * 2 + 1;
    }

    /***
     * 右孩子
     */
    private int rightChild(int pos) {
        return pos * 2 + 2;
    }

    /***
     * 值交换
     */
    private void swap(int[] heap, int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    /***
     * 按树结构打印
     */
    public void printHeap(int[] heap, int size) {
        int a = 2;
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
            if (i == a - 2) {
                a *= 2;
                System.out.println();
            }
        }
        System.out.println();
    }

    /***
     * 打印排序后数组
     */
    public void printArrSorted(int[] arr) {
        Arrays.sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /***
     * 打印数组
     */
    public void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /***
     * 前N个最大值
     */
    @Test
    public void topMaxN() {
        final int len = 20;
        final int topN = 7;
        int[] heap = new int[len];
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            heap[i] = random.nextInt(100);
        }

        //创建topN最小堆
        createHeapMin(heap, topN);
        //遍历数组，并维护topN最小堆
        findTopMaxN(heap, topN);


        printHeap(heap, topN);
        printArr(heap);
        printArrSorted(heap);
        System.out.println();
        System.out.println(heap[heap.length - topN]);
    }


    /***
     * 遍历数据组，并维护最小堆
     */
    private void findTopMaxN(int[] heap, int topN) {
        for (int i = topN; i < heap.length; i++) {
            adjustDownTopMaxN(heap, topN, i);
        }
    }

    /***
     * 创建最小堆
     */
    private void createHeapMin(int[] heap, int size) {
        for (int i = 1; i < size; i++) {
            adjustUpMin(heap, i);
        }
    }

    /***
     * 向上调整新加入节点位置
     */
    private void adjustUpMin(int[] heap, int pos) {
        while (parent(pos) >= 0 && heap[parent(pos)] > heap[pos]) {
            int parent = parent(pos);
            swap(heap, parent, pos);
            pos = parent;
        }
    }

    /***
     * 向下调整新加入节点位置，并维护最小堆
     */
    private void adjustDownTopMaxN(int[] heap, int topN, int pos) {
        //比topN中最小的还要小直接返回
        if (heap[0] >= heap[pos]) {
            return;
        }
        swap(heap, 0, pos);
        pos = 0;
        while (leftChild(pos) < topN) {
            int child = leftChild(pos);
            //判断左右孩子的大小，child代表较小的孩子
            if (child + 1 < topN && heap[child + 1] < heap[child]) {
                child++;
            }
            //新节点比较小的孩子都小，说明找到对应位置，直接跳出勋魂
            if (heap[child] >= heap[pos]) {
                break;
            }
            swap(heap, pos, child);
            pos = child;
        }
    }


    /***
     * 前N个最小值
     */
    @Test
    public void topMinN() {
        final int len = 200;
        final int topN = 7;
        int[] heap = new int[len];
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            heap[i] = random.nextInt(10000);
        }
        //创建topN最大堆
        createHeapMax(heap, topN);
        //遍历数组，并维护topN最小堆
        findTopMinN(heap,topN);

        printHeap(heap, topN);
        printArrSorted(heap);
        System.out.println();
        System.out.println(heap[topN-1]);
    }

    /***
     * 遍历数据组，并维护最大堆
     */
    private void findTopMinN(int[] heap, int topN) {
        for (int i = topN; i < heap.length; i++) {
            adjustDownTopMinN(heap, topN, i);
        }
    }

    /***
     * 创建最大堆
     */
    private void createHeapMax(int[] heap, int size) {
        for (int i = 1; i < size; i++) {
            adjustUpMax(heap, i);
        }
    }

    /***
     * 向上调整新加入节点位置
     */
    private void adjustUpMax(int[] heap, int pos) {
        while (parent(pos) >= 0 && heap[parent(pos)] < heap[pos]) {
            int parent = parent(pos);
            swap(heap, parent, pos);
            pos = parent;
        }
    }

    /***
     * 向下调整新加入节点位置，并维护最大堆
     */
    private void adjustDownTopMinN(int[] heap, int topN, int pos) {
        //比topN中最大的还要大直接返回
        if (heap[0] <= heap[pos]) {
            return;
        }
        swap(heap, 0, pos);
        pos = 0;
        while (leftChild(pos) < topN) {
            int child = leftChild(pos);
            //判断左右孩子的大小，child代表较大的孩子
            if (child + 1 < topN && heap[child + 1] > heap[child]) {
                child++;
            }
            //新节点比较大的孩子都大，说明找到位置，直接跳出循环
            if (heap[child] <= heap[pos]) {
                break;
            }
            swap(heap, pos, child);
            pos = child;
        }
    }
}
