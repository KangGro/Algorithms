package com.mr.kangaroo.sort;

import java.util.Arrays;

/**
 * Created by mr-kangaroo on 16/10/23.
 */
public class MergeSort {


    public static void mergerSort(int[] src){
        if(src.length <= 0) return ;
        if(src.length > 1){
            int mid = src.length / 2;
            int[] tmpA = new int[mid];
            int[] tmpB = new int[src.length - mid];
            System.arraycopy(src,0,tmpA,0,mid);
            System.arraycopy(src,mid,tmpB,0,src.length - mid);
            mergerSort(tmpA);
            mergerSort(tmpB);
            merge(tmpA,tmpB,src);
        }
    }

    public static void merge(int[] tmpA,int[] tmpB ,int[] src){
        int j = 0;
        int k = 0;
        for (int i = 0 ;i < tmpA.length;){
            if(tmpA[i] > tmpB[j]){
                src[k] = tmpB[j];
                j = j + 1;
            }else{
                src[k] = tmpA[i];
                i = i + 1;
            }
            k = k + 1;
            if(i == tmpA.length){
                System.arraycopy(tmpB,j,src,k,tmpB.length - j);
                break;
            }
            if(j == tmpB.length){
                System.arraycopy(tmpA,i,src,k,tmpA.length - i);
                break;
            }
        }

    }
    public static void main(String[] args) {
        mergerSort(DataSource.dataSource);
    }
}
