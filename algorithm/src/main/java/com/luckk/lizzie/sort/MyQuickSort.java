package com.luckk.lizzie.sort;

import java.util.Arrays;

/**
 * @Author liukun.inspire
 * @Date 2023/8/4 18:16
 * @PackageName: com.luckk.lizzie.sort
 * @ClassName: MyQuickSort
 * @Version 1.0
 */
public class MyQuickSort {
    public static void main(String[] args) {
        int[] a = {7, 2, 4, 6, 1, 3, 7, 9, 8, 5};
        // int []a = {1,2,3,4,5,6,7};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    // 时间复杂度O(n*logn)，空间复杂度O(n*logn)
    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            // 找出基准
            int partition = partition(arr, startIndex, endIndex);
            // 分成两边递归进行
            quickSort(arr, startIndex, partition - 1);
            quickSort(arr, partition + 1, endIndex);
        }
    }

    // 找基准
    private static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            // 找到left比基准大，right比基准小，进行交换
            if (left < right) {
                swap(arr, left, right);
            }
        }
        // 第一轮完成，让left和right重合的位置和基准交换，返回基准的位置
        swap(arr, startIndex, left);
        // arr[left] = pivot;
        return left;
    }

    // 两数交换
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
