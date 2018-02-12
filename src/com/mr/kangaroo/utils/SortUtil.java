package com.mr.kangaroo.utils;

import java.util.Arrays;

/**
 * @author daisy
 * @desc
 * @create 2018/2/13
 */
public class SortUtil {
    public static int[] sourceArr = new int[]{6,1,4,7,9,2,8,3};

    /**
     * a < b
     * @param a
     * @param b
     * @return
     */
    public static Boolean less(int a, int b){
        return a < b;
    }

    /**
     * 交换
     * @param a
     * @param b
     */
    public static void exch(int[] arr, int a , int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
        System.out.println(Arrays.toString(sourceArr));
    }

    /**
     * 打印
     * @param sourceArr
     */
    public static void show(int[] sourceArr){
        System.out.println(Arrays.toString(sourceArr));
    }
}
