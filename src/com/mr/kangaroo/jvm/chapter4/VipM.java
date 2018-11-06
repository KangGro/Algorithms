package com.mr.kangaroo.jvm.chapter4;

/**
 * @author daisy
 * @desc
 * @create 2018/11/5
 */
public class VipM extends M<VIP>{

    @Override
    public double actionPrice(double price, VIP customer) {
        return 0;
    }

}
