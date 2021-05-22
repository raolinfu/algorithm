package com.rao.base;
/*
* 一.先来说说Java的基本数据类型和引用类型
    * 八大基本数据类型：Byte，short，int，long，double，float，boolean，char，
    * 其中占一个字节的是byte，short和char占两个字节，int，float占四个字节，double和long占8个字节，boolean只有true和false，这八种数据变量中直接存储值
    * 八大基本数据类型对应着各自的封装类型，提供了更多的方法，且不进行初始化时值默认为空（基本数据类型必须初始化）
    * 像String类型属于引用类型，变量中存储的是地址，对应的地址存储数据
二.equals和==
    * equals 是比较内存地址上面的值是否相同
    *  "=="操作符的作用
        1、用于基本数据类型的比较，基础数据类型没有equals
        2、判断引用是否指向堆内存的同一块地址。
 三、自动装箱都是通过包装类的valueOf()方法来实现的.自动拆箱都是通过包装类对象的xxxValue()来实现的
    *
* */
public class BaseType {
    static public void testEqual(){
        int a = 1;
        int b = 1;
        System.out.println(a == b);

        Integer c = 128;
        Integer d = 128;
        Integer e = 12;
        Integer f = 12;
        System.out.println(c == d);   // 输出来为false
        System.out.println(e == f);     // 输出来为true
        System.out.println(c.equals(d));


    }

    public static void main(String[] args) {
        testEqual();
    }
}
