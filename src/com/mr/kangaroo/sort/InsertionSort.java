package com.mr.kangaroo.sort;

import com.mr.kangaroo.DataSource.DataSource;

/**
 * Created by mr-kangaroo on 16/10/23.
 * 插入排序;
 *
 * 思路: 向一个有序的序列中插入新的元素;
 * 减治法,减一
 *
 */
public class InsertionSort {
    public static void insertionSort(int[] src){
        for (int i = 1; i < src.length; i++) {
            int k = src[i];
            int j= i-1;
            for(;j>=0;){
                if(src[j] > k){
                    src[j+1] = src[j];
                    j--;
                }else{
                    break;
                }
            }
            src[j+1] = k;
        }
    }
    public static void main(String[]args){
        insertionSort(DataSource.dataSource);
    }

}
