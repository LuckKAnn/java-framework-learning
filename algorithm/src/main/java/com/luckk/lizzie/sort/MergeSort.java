package com.luckk.lizzie.sort;

import java.util.Arrays;

/**
 * @Author liukun.inspire
 * @Date 2023/6/18 14:07
 * @PackageName: com.luckk.lizzie.sort
 * @ClassName: MergeSort
 * @Version 1.0
 */
public class MergeSort {

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int[] temp = new int[arr.length];
        doMergeSort(arr, 0, arr.length - 1, temp);
    }

    private static void doMergeSort(int[] arr, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        doMergeSort(arr, start, mid, temp);
        doMergeSort(arr, mid + 1, end, temp);
        doMerge(arr, start, end, temp);
    }

    private static void doMerge(int[] arr, int left, int end, int[] temp) {
        int mid =  left + (end - left)/2;
        int rightIndex =mid+1;
        int tmpIdx = left;
        int origin = left;

        while (left <= mid && rightIndex<=end){
            if (arr[left]< arr[rightIndex]){
                temp[tmpIdx++] = arr[left++];
            }else{
                temp[tmpIdx++] = arr[rightIndex++];
            }
        }

        while (left<=mid){
            temp[tmpIdx++] = arr[left++];
        }
        while (rightIndex<=end){
            temp[tmpIdx++] = arr[rightIndex++];
        }

        for (int i = origin; i <= end; i++) {
            arr[i] = temp[i];
        }
    }


    public static void main(String[] args) {
        // int []arr = new int[]{1,23,35,435,356,3};
        int []arr = new int[]{21,1};
        MergeSort.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
