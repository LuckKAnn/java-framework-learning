package com.luckk.lizzie.sort;
import java.util.Arrays;

/**
 * @Author liukun.inspire
 * @Date 2023/6/18 11:40
 * @PackageName: com.luckk.lizzie.sort
 * @ClassName: QuickSort
 * @Version 1.0
 */
public class QuickSort {

    public static void doSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSortHelper(arr, 0, arr.length - 1);
    }

    private static void quickSortHelper(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = arr[(end + start) / 2];
        int left = start;
        int right = end;

        while (left <= right) {
            // = pivot 的时候，两边都可以存留。进而导致可能来回交换，所以需要在交换之后++ --
            while (left <= right && arr[left] < pivot) {
                left++;
            }
            while (left <= right && arr[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                // left++;
                // right--;
            }
        }
        quickSortHelper(arr, start, right);
        quickSortHelper(arr, left, end);

    }

    public static void main(String[] args) {
        int[] arr = {2, 3214, 3245, 345, 436, 45, 645, 2, 2, 3};
        QuickSort.doSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
