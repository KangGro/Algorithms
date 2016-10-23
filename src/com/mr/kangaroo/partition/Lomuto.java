package com.mr.kangaroo.partition;

import com.mr.kangaroo.DataSource.DataSource;

import java.util.Arrays;

/**
 * Created by mr-kangaroo on 16/10/23.
 *
 * 划分算法;
 *
 * 顺序统计量,中值,中轴
 *
 */
public class Lomuto {

    public static int lomutoPartiton(int[] src){
//        System.out.println("--src--" + Arrays.toString(src));
        int p = src[0];
        int s = 0;
        for (int i = 1 ; i <src.length;i++){
            if(src[i] < p){
                s = s + 1;
                int tmp = src[s];
                src[s] = src[i];
                src[i] = tmp;
//                System.out.println("--src--" + Arrays.toString(src));
            }
        }

        int tmp = src[0];
        src[0] = src[s];
        src[s] = tmp;

        System.out.println("--src--" + Arrays.toString(src));
        return s ;
    }

    public static void main(String[] args) {
        lomutoPartiton(DataSource.dataSource);
    }
}
