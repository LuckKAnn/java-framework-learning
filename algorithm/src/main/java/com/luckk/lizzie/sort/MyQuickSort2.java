package com.luckk.lizzie.sort;

import java.util.Arrays;

/**
 * @Author liukun.inspire
 * @Date 2023/8/29 22:22
 * @PackageName: com.luckk.lizzie.sort
 * @ClassName: MyQuickSort2
 * @Version 1.0
 */
public class MyQuickSort2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3242, 35, 34, 6, 457, 56, 7};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start > end) {
            return;
        }
        int mid = doQuickSort(arr, start, end);
        quickSort(arr, start, mid - 1);
        quickSort(arr, mid + 1, end);
    }

    private static int doQuickSort(int[] arr, int start, int end) {
        int pivot = arr[start];
        int low = start;
        int high = end;
        while (low < high) {
            while (low < high && arr[high] >= pivot) high--;

            while (low < high && arr[low] <= pivot) low++;

            if (low < high) {
                // 执行交换
                int tmp = arr[high];
                arr[high] = arr[low];
                arr[low] = tmp;
            }
        }

        // 执行完成之后，其实需要交换pivot吗
        int tmp = arr[low];
        arr[low] = pivot;
        arr[start] = tmp;

        return low;

    }
}
