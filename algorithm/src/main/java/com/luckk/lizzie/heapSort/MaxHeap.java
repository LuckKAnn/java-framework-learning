package com.luckk.lizzie.heapSort;

import java.util.Arrays;

/**
 * @Author liukun.inspire
 * @Date 2023/3/29 00:32
 * @PackageName: com.luckk.lizzie.heapSort
 * @ClassName: MaxHeap
 * @Version 1.0
 */
public class MaxHeap {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 23, 3254, 45, 435, 654, 34};

        getMaxHeap(arr, true);

        System.out.println(Arrays.toString(arr));
        int[] newHeap = add(arr, 122);

        System.out.println(Arrays.toString(newHeap));

        System.out.println("-------");
        int poll = poll(newHeap);
        System.out.println(poll);

    }


    /**
     * 其实堆排序应该没有什么插入堆概念
     * 只有最大堆和最小堆应该有这个概念
     *
     * @param arr
     * @param element
     * @return
     */
    public static int[] add(int[] arr, int element) {
        int[] newArr = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        int idx = arr.length;
        newArr[idx] = element;
        flow(newArr, idx);
        return newArr;
    }

    public static int poll(int[] arr) {
        if (arr.length == 0) {
            throw new NullPointerException();
        }
        int res = arr[0];
        int[] newArr = new int[arr.length - 1];
        for (int i = 1; i < arr.length - 1; i++) {
            newArr[i] = arr[i];
        }
        newArr[0] = arr[arr.length - 1];

        adjustHeap(newArr, 0, newArr.length, true);

        System.out.println(Arrays.toString(newArr));

        return res;
    }


    public static void flow(int[] newArr, int idx) {
        int element = newArr[idx];
        while (idx != 0) {
            if (newArr[idx] > newArr[idx / 2]) {
                newArr[idx] = newArr[idx / 2];
                idx /= 2;
            } else {
                break;
            }
        }
        newArr[idx] = element;
    }

    public static void getMaxHeap(int[] arr, boolean maxSort) {

        for (int i = arr.length / 2; i >= 0; i--) {
            adjustHeap(arr, i, arr.length, maxSort);
        }

    }

    public static void adjustHeap(int[] arr, int parent, int len, boolean maxSort) {
        // len 为开区间

        int tmp = arr[parent];

        int leftIdx = parent * 2 + 1;

        while (leftIdx < len) {
            int rightIdx = leftIdx + 1;

            if (maxSort) {
                if (rightIdx < len && arr[rightIdx] > arr[leftIdx]) {
                    leftIdx++;
                }
                if (tmp >= arr[leftIdx]) {
                    break;
                }
            } else {
                if (rightIdx < len && arr[rightIdx] < arr[leftIdx]) {
                    leftIdx++;
                }
                if (tmp <= arr[leftIdx]) {
                    break;
                }
            }

            // 还要继续往下
            arr[parent] = arr[leftIdx];


            parent = leftIdx;
            leftIdx = leftIdx * 2 + 1;

        }
        arr[parent] = tmp;

    }
}
