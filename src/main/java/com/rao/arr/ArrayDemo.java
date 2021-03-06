package com.rao.arr;

import java.util.Arrays;
import java.util.Comparator;

/*
*
* https://blog.csdn.net/ezconn/article/details/94066710
*   1 数组既可以存储基本数据类型,又可以存储引用数据类型,基本数据类型存储的是值,引用数据类型存储的是地址值
    2 集合只能存储引用数据类型(对象)集合中也可以存储基本数据类型,但是在存储的时候会自动装箱变成对象
* */
public class ArrayDemo implements Comparator<String>{
    static public void testArr(){
        char[] arr = new char[10];
        System.out.println(arr.getClass());
        arr.hashCode();
    }



    @Override
    public int compare(String o1, String o2) {
        return (o1 + o2).compareTo(o2 + o1);
    }



    public static void main(String[] args) {

        String[] a = {"2", "1", "34", "12"};
        System.out.println(a.toString());
        Arrays.sort(a, new ArrayDemo());
        System.out.println(a.toString());
        testArr();
    }
}
