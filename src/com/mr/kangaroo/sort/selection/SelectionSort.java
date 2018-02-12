package com.mr.kangaroo.sort.selection;

import com.mr.kangaroo.utils.SortUtil;

/**
 * @author daisy
 * @desc
 * @create 2018/2/13
 */
public class SelectionSort {
    public static void selectionSort(int[] arr){
        int len = arr.length;
        for(int i=0 ; i< len-1; i++){
            int min = i;
            for(int j = i + 1; j< len; j++){
                if(SortUtil.less(arr[j],arr[min])){
                    min = j;
                }
            }
            SortUtil.exch(arr, i, min);
        }
    }

    /**
     * 手写
     * @param arr
     */
    public static void selectionSort2(int[] arr){
        int len = arr.length;
        for(int i=0 ; i< len-1; i++){
            for(int j = i + 1; j< len; j++){
                if(SortUtil.less(arr[j],arr[i])){
                    SortUtil.exch(arr, j, i);
                }
            }
        }
    }
    public static void main(String[] args) {
        SortUtil.show(SortUtil.sourceArr);
        selectionSort2(SortUtil.sourceArr);
        SortUtil.show(SortUtil.sourceArr);
    }
}
