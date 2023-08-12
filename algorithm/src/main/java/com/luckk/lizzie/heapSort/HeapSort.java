package com.luckk.lizzie.heapSort;

import java.util.Arrays;

/**
 * @Author liukun.inspire
 * @Date 2023/3/28 21:42
 * @PackageName: com.luckk.lizzie.heapSort
 * @ClassName: HeapSort
 * @Version 1.0
 */
public class HeapSort {

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] arr = {100, 2012, 1223, 23, 2332, 212};
        heapSort.doheapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    void doheapSort(int[] arr) {
        // 从第一个非叶子节点开始
        // 建堆的过程
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length - 1);
        }

        // 交换完成一轮了，然后把最上面的节点和最末尾的节点进行交换
        // 把堆顶和最后堆元素交换
        for (int i = arr.length - 1; i >= 0; i--) {
            // 交换第一个节点
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;

            adjustHeap(arr, 0, i - 1);
        }

    }


    void adjustHeap(int[] arr, int parent, int len) {
        // len 为开区间
        int tmp = arr[parent];
        int leftIdx = parent * 2 + 1;

        while (leftIdx <= len) {
            int rightIdx = leftIdx + 1;
            if (rightIdx < len && arr[rightIdx] > arr[leftIdx]) {
                leftIdx++;
            }
            if (tmp >= arr[leftIdx]) {
                break;
            }
            // 还要继续往下
            arr[parent] = arr[leftIdx];
            arr[leftIdx] =tmp;

            parent = leftIdx;
            leftIdx = leftIdx * 2 + 1;
        }
        // arr[parent] = tmp;

    }
}
