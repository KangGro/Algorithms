package com.mr.kangaroo.sort.insertion;

import com.mr.kangaroo.utils.SortUtil;

/**
 * @author daisy
 * @desc
 * @create 2018/2/13
 */
public class ShellSort {
    public static void shellSort(int[] arr){
        int len = arr.length;
        int shell = 1;
        while (shell < len / 3) {
            shell = 3*shell + 1;
        }
        while(shell >= 1){
            for(int i = shell ; i < len ; i = i + shell){
                for(int j = i ; j - shell >= 0; j -= shell){
                    if(SortUtil.less(arr[j], arr[j - shell])){
                        SortUtil.exch(arr, j, j - shell);
                    }
                }
            }
            shell = shell / 3;
        }
    }

    public static void shellSort2(int[] arr){

    }

    public static void main(String[] args) {
        shellSort(SortUtil.sourceArr);
    }
}
