package com.mr.kangaroo.select;

import com.mr.kangaroo.partition.Lomuto;
import com.mr.kangaroo.DataSource.DataSource;

/**
 * Created by mr-kangaroo on 16/10/23.
 *
 *  递归
 *  减可变规模算法
 *
 */
public class QuickSelect {

    public static int quickSelect(int[] src ,int k){
        int s = Lomuto.lomutoPartiton(src);
        int left = 0 ;
        int right = src.length - 1;
        if(s ==  k - 1){
            return src[s];
        }else if(s > k -1){
            int[] tmpA = new int[s + 1];
            System.arraycopy(src,0,tmpA,0,s+1);
            return quickSelect(tmpA,k);
        }else{
            int[] tmpB = new int[src.length - s + 1];
            System.arraycopy(src,s+1,tmpB,0,tmpB.length);
            return quickSelect(tmpB,k);
        }
    }
    public static void main(String[] args){
        int k = quickSelect(DataSource.dataSource,2);
        System.out.println(k);
    }
}
