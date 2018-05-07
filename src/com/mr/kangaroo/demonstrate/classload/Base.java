package com.mr.kangaroo.demonstrate.classload;

/**
 * @author daisy
 * @desc
 * @create 2018/5/7
 */
public class ClazzA {
    static {
        System.out.println("== ClazzA static block A==");
    }
    public static int a = 3;

    public ClazzA() {
        a = 4;
        System.out.println("== ClazzA construct==");
    }

    static {
        a = 5;
        System.out.println("== ClazzA static block B== a:" + a);
    }

    public static void main(String[] args) {
        ClazzA a = new ClazzA();
        System.out.println(ClazzA.a);
    }
}
