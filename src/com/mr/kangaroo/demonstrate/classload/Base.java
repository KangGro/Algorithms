package com.mr.kangaroo.demonstrate.classload;

/**
 * @author daisy
 * @desc
 * @create 2018/5/7
 */
public class Base {
    static {
        System.out.println("== Base static block A==");
    }
    public static int a = 3;

    public Base() {
        a = 4;
        System.out.println("== Base construct==");
    }

    static {
        a = 5;
        System.out.println("== Base static block B== a:" + a);
    }

    public static void main(String[] args) {
        Base a = new Base();
        System.out.println(Base.a);
    }
}
