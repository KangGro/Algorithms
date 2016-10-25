package com.mr.kangaroo.sort;

import com.mr.kangaroo.DataSource.DataSource;

import java.util.Arrays;

/**
 * Created by mr-kangaroo on 16/10/25.
 *
 * 按照指定的步长序列进行排序;
 *
 */
public class ShellSort {

    public static void shellSort(int[] src){
        System.out.println(Arrays.toString(src));
        int n = src.length;
        int op=0;
        int h,i,j,temp;
        for(h=n/2;h>0;h=h/2){
            for(i=h;i<n;i++){
                temp=src[i];
                for(j=i-h;j>=0&&src[j]>temp;j-=h){
                    src[j+h]=src[j];
                    op++;
                }
                src[j+h]=temp;
                op++;
            }
        }
        System.out.println(Arrays.toString(src));
    }
    public static void main(String[] args){
        shellSort(DataSource.dataSource);
    }
}
