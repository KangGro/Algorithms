package com.mr.kangaroo.sort;

import com.mr.kangaroo.DataSource.DataSource;

import java.util.Arrays;

/**
 *
 * 折半插入排序 , 与直接插入相比较只是少了比较次数;
 *
 *
 * Created by mr-kangaroo on 16/10/25.
 */
public class BinaryInsertSort {

    public static void binaryInsertSort(int[] src){
        System.out.println(Arrays.toString(src));
        for (int i = 1;i < src.length;i++){
            int left = 0;
            int right = i - 1;
            int tmp = src[i];
            while(left <= right){
                int mid = (left + right) / 2;
                if(src[i] > src[mid]){
                    left = mid +1;
                }else{
                    right = mid - 1;
                }
            }
            for (int j = i-1;j >= right + 1;j--){
                src[j+1] = src[j];
            }
            src[right+1] = tmp;
        }
        System.out.println(Arrays.toString(src));
    }

    public static void main(String[] args){
        binaryInsertSort(DataSource.dataSource);
    }
}
