package com.mr.kangaroo.sort.merge;

import com.mr.kangaroo.utils.SortUtil;

import java.util.Arrays;

/**
 * @author daisy
 * @desc
 * @create 2018/2/13
 */
public class MergeSort {
    public static void merge(int[] srcArr, int[] destArr, int low, int mid, int high) {
        for(int k = low ; k <= high; k++){
            destArr[k] = srcArr[k];
        }
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                srcArr[k] = destArr[j++];
            } else if (j > high) {
                srcArr[k] = destArr[i++];
            } else if (SortUtil.less(destArr[j], destArr[i])) {
                srcArr[k] = destArr[j++];
            } else {
                srcArr[k] = destArr[i++];
            }
        }
    }

    public static void sort(int[] srcArr, int[] destArr, int low, int high) {
        if (high <= low) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(srcArr, destArr, low, mid);
        sort(srcArr, destArr, mid + 1, high);
        merge(srcArr, destArr, low, mid, high);
    }

    public static void mergeSort(int[] arr) {
        int[] destArr = new int[arr.length];
        sort(arr, destArr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        mergeSort(SortUtil.sourceArr);
        System.out.println(Arrays
                .toString(SortUtil.sourceArr));
    }
}
