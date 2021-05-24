package com.rao.base;

public class StrConstant {
    /*
    * 堆
        存储的是对象，每个对象都包含一个与之对应的class
        JVM只有一个堆区(heap)被所有线程共享，堆中不存放基本类型和对象引用，只存放对象本身
        对象的由垃圾回收器负责回收，因此大小和生命周期不需要确定
      栈
        每个线程包含一个栈区，栈中只保存基础数据类型的对象和自定义对象的引用(不是对象)
        每个栈中的数据(原始类型和对象引用)都是私有的
        栈分为3个部分：基本类型变量区、执行环境上下文、操作指令区(存放操作指令)
        数据大小和生命周期是可以确定的，当没有引用指向数据时，这个数据就会自动消失
      方法区
        静态区，跟堆一样，被所有的线程共享
        方法区中包含的都是在整个程序中永远唯一的元素，如class，static变量
        * 字符串常量池在方法区
      String是不可变的 博客地址
      * https://blog.csdn.net/zhangjg_blog/article/details/18319521?utm_medium=
      distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%
      7Edefault-3.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%
      7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-3.control
        *

    * */
    static public void testConstant(){
        String a = "abc";
        String b = "abc";                       // 常量池中创建
        String c = new String("abc");   // 堆中创建
        System.out.println(a == b);
        System.out.println(c == a);
    }

    public static void main(String[] args) {
        testConstant();
    }
}
