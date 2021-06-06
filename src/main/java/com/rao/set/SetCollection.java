package com.rao.set;

import java.util.HashSet;

/*
* 博客地址https://blog.csdn.net/a724888/article/details/80295328
* set的基础和原理
* 1、hashSet底层由hashMap实现
*
* 2、treeSet底层由treeMap实现
*
* 3、LinkedHashSet
*   是hashSet的扩展版本
*   LinkedHashSet 通过继承 HashSet，底层使用 LinkedHashMap
* */
public class SetCollection {

    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(12);
        System.out.println(set.toString());
        set.remove(12);
        System.out.println(set.toString());
    }
}
