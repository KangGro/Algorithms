package com.mr.kangaroo.demonstrate.classload;

/**
 * @author daisy
 * @desc
 * @create 2018/5/7
 */
public class ClazzA extends Base {
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

    private void privateMethod(){
        System.out.println("== ClazzA privateMethod==");
    }

    private void publicMethod(){
        System.out.println("== ClazzA publicMethod==");
    }

    public static void main(String[] args) {
        ClazzA a = new ClazzA();
        System.out.println(ClazzA.a);
    }
}
