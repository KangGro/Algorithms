package com.mr.kangaroo.sort;

import java.util.Arrays;

import com.mr.kangaroo.DataSource.DataSource;

/**
 * 冒泡排序;
 * 时间复杂度： n + (n - 1) + (n - 2) + · · · + 2 + 1;
 *
 * @author admin
 */
public class BubbleSort {
    /**
     * 时间复杂度：
     * 最优: n + (n - 1) + (n - 2) + · · · + 2 + 1;
     * 最差: n + (n - 1) + (n - 2) + · · · + 2 + 1;
     * 平均: n + (n - 1) + (n - 2) + · · · + 2 + 1;
     *
     * @param src
     */
    public static void bubbleSort(int[] src) {
        if (src.length <= 0) return;
        for (int i = 0; i < src.length - 1; i++) {
            for (int j = 0; j < src.length - i - 1; j++) {
                //ASC
                if (src[j] > src[j + 1]) {
                    //Desc
//				if(src[j] < src[j+1]){
                    int tmp = src[j];
                    src[j] = src[j + 1];
                    src[j + 1] = tmp;
                }
            }
            System.out.println(Arrays.toString(src));
        }

    }

    /**
     * 时间复杂度：
     * 最优: n;
     * 最差: n + (n - 1) + (n - 2) + · · · + 2 + 1;
     * 平均: n + (n - 1) + (n - 2) + · · · + 2 + 1;
     *
     * @param src
     */
    public static void bubbleSortPro(int[] src) {
        if (src.length <= 0) return;
        boolean didSwap = false;
        for (int i = 0; i < src.length - 1; i++) {
            for (int j = 0; j < src.length - i - 1; j++) {
                if (src[j] > src[j + 1]) {
                    int tmp = src[j];
                    src[j] = src[j + 1];
                    src[j + 1] = tmp;
                    didSwap = true;
                }
            }
            System.out.println(Arrays.toString(src));
            if (!didSwap) return;
        }
    }

    public static void main(String[] args) {
        bubbleSort(DataSource.dataSource1);
        System.out.println("------------------------------");
        bubbleSortPro(DataSource.dataSource1);
    }
}
