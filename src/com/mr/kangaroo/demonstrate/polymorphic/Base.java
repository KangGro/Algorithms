package com.mr.kangaroo.demonstrate.polymorphic;

/**
 * @author daisy
 * @desc 抽象类多态
 * @create 2018/5/7
 */
public abstract class Base {

    private void privateMethod(){
        System.out.println("==privateMethod===");
    }

    public abstract void absMethod();
}
