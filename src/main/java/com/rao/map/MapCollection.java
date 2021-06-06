package com.rao.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/*
* java中map的基础和原理
* 1、HashMap
*   数组+链表形式实现 链表过长会转化成红黑树 线程不安全
*   允许null值
* 2、concurrentHashMap
*   分段 线程安全
*   1.7中ConcurrentHashMap使用了分段锁，1.8中则使用了CAS算法。
*
* 3、HashTable
*   https://blog.csdn.net/qq_27574367/article/details/88527853
*   线程安全，已废弃，主要是效率不高
*   put方法不允许null值，如果发现是null，则直接抛出异常。
*
* 4、TreeMap
*   底层由红黑树实现
*   key和value都不允许为null  是红黑树 所以有排序
*   Integer和String是有默认的排序  但是其它类型的 需要我们自己实现Comparable 并重写
*   非线程安全
*
* 5、LinkedHashMap
*   优秀的博客地址https://segmentfault.com/a/1190000012964859
*   继承HashMap 保持原有的数据
*   非线程安全
* */
public class MapCollection {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, Integer> hashMap = new ConcurrentHashMap<>();
        HashMap<Integer, String> map = new HashMap<>();
        map.put(11, "rao");
        map.put(null, null);
        System.out.println(map.toString());

        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("rao", 13);

        Hashtable<Integer, Integer> table = new Hashtable<>();
        table.put(19, 12);
        table.put(12, 13);
        table.put(20, 34);
        System.out.println(table.toString());

        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(12, 34);
        linkedHashMap.put(23, 48);
        linkedHashMap.put(20, 3);
        System.out.println(linkedHashMap.toString());

    }
}
