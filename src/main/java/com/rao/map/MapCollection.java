package com.rao.map;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/*
* java中map的基础和原理
* 1、HashMap
*   数组+链表形式实现 线程不安全
* 2、concurrentHashMap
*   分段 线程安全
*
* 3、HashTable
*   线程安全
*
* 4、
* */
public class MapCollection {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, Integer> hashMap = new ConcurrentHashMap<>();
        HashMap<Integer, String> map = new HashMap<>();

    }
}
