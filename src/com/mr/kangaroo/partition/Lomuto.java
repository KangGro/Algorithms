package com.mr.kangaroo.partition;

import com.mr.kangaroo.DataSource.DataSource;

/**
 * Created by mr-kangaroo on 16/10/23.
 * <p>
 * 划分算法;
 * <p>
 * 顺序统计量,中值,中轴
 */
public class Lomuto {

    public static int lomutoPartiton(int[] src) {
        int p = src[0];
        int s = 0;
        for (int i = 1; i < src.length; i++) {
            if (src[i] < p) {
                s = s + 1;
                int tmp = src[s];
                src[s] = src[i];
                src[i] = tmp;
            }
        }
        int tmp = src[0];
        src[0] = src[s];
        src[s] = tmp;
        return s;
    }

    public static void main(String[] args) {
        lomutoPartiton(DataSource.dataSource);
    }
}
