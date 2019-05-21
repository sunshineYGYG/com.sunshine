package com.sunshine.AlgorithmTemplate;

import org.junit.Test;

import java.util.Random;

public class HeapTemplate {

    @Test
    public void test() {
        Random random = new Random();
        final int size = 7;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100);
        }
        printHeap(arr);
//        int[] heap = createHeap(size, arr);
        int[] heap = createHeapMin(size, arr);
        printHeap(heap);
    }

    @Test
    public void test2() {
        Random random = new Random();
        final int size = 8;
        int[] arr = new int[size];
        for (int i = 1; i < size; i++) {
            arr[i] = random.nextInt(100);
//            adjustUp(arr, i);
            adjustUpMin(arr,i);
        }
        printHeap(arr);
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return pos * 2;
    }

    private int right(int pos) {
        return pos * 2 + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void printHeap(int[] heap) {
        int a = 2;
        for (int i = 1; i < heap.length; i++) {
            System.out.print(heap[i] + " ");
            if (i == a - 1) {
                System.out.println();
                a *= 2;
            }
        }
        System.out.println();
    }


    public int[] createHeap(int size, int[] data) {
        int[] heap = new int[size + 1];
        for (int i = 1; i <= size; i++) {
            heap[i] = data[i - 1];
        }
        for (int i = heap.length / 2; i > 0; i--) {
            adjustDown(heap, i);
        }
        return heap;
    }
    public int[] createHeapMin(int size, int[] data) {
        int[] heap = new int[size + 1];
        for (int i = 1; i <= size; i++) {
            heap[i] = data[i - 1];
        }
        for (int i = heap.length / 2; i > 0; i--) {
            adjustDownMin(heap, i);
        }
        return heap;
    }


    private void adjustDown(int[] arr, int pos) {
        int length = arr.length;
        int child = pos;
        while (leftChild(child) < length) {
            int cur = child;
            child = leftChild(cur);
            if (child + 1 < length && arr[child + 1] > arr[child]) {
                child++;
            }
            if (arr[child] <= arr[cur]) {
                break;
            }
            swap(arr, child, cur);
        }
    }

    private void adjustUp(int[] arr, int pos) {
        while (parent(pos) > 0 && arr[parent(pos)] < arr[pos]) {
            int parent = parent(pos);
            swap(arr, parent, pos);
            pos = parent;
        }
    }

    private void adjustDownMin(int[] arr, int pos) {
        int length = arr.length;
        int child = pos;
        while (leftChild(child) < length) {
            int cur = child;
            child = leftChild(cur);
            if (child + 1 < length && arr[child + 1] < arr[child]) {
                child++;
            }
            if (arr[child] >= arr[cur]) {
                break;
            }
            swap(arr, child, cur);
        }
    }

    private void adjustUpMin(int[] arr, int pos) {
        while (parent(pos) > 0 && arr[parent(pos)] > arr[pos]) {
            int parent = parent(pos);
            swap(arr, parent, pos);
            pos = parent;
        }
    }
}
