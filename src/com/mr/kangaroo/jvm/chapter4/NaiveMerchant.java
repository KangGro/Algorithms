package com.mr.kangaroo.jvm.chapter4;

/**
 * @author daisy
 * @desc
 * @create 2018/11/5
 */
public class NaiveMerchant extends Merchant {

    @Override
    public Double actionPrice(double price, Customer customer) {
        System.out.println("===NaiveMerchant.actionPrice()===");
        return null;
    }

}
