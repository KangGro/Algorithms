package com.mr.kangaroo.demonstrate.polymorphic;

/**
 * @author daisy
 * @desc
 * @create 2018/5/7
 */
public class B extends A{

    @Override
    public void absMethod(){
        System.out.println("===B.absMethod==");
    }

    public void methodB(){
        System.out.println("===B.methodB===");
    }

    public static void main(String[] args) {
        A a = new B();
        a.absMethod();
        A a1 = (A)new B();
        a1.absMethod();
        //编译是只检查是否存在继承关系，运行时会检查对象真正的类型
        B b = (B)new A();
        b.absMethod();
    }
}
