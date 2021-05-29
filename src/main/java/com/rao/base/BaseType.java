package com.rao.base;

import java.util.Objects;

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
    * 如果类没有覆盖equals方法时，默认会用==进行比较，实际上比较的是内存地址了Object类默认返回地址

 三、自动装箱都是通过包装类的valueOf()方法来实现的.自动拆箱都是通过包装类对象的xxxValue()来实现的
    * 自动拆装箱机制提供了一个缓存机制来节省内存和提高性能，Integer对象通过使用相同的对象引用来比较大小，
    * 而这个相同的对象就是缓存
    * 自动装箱时，如果数字在-128至127之间时，会直接使用缓存中的对象，而不是重新创建一个对象，否则会重新创建对象，
    * 可以从valueOf源码看到

 四、https://blog.csdn.net/lijiecao0226/article/details/24609559
 * equals(): 用来判断两个对象是否相同，再Object类中是通过判断对象间的内存地址来决定是否相同
    hashCode(): 获取哈希码，也称为散列码，返回一个int整数。这个哈希码的作用是确定该对象在哈希表中的索引位置。
    *   hashCode() 在散列表中才有用，在其它情况下没用。在散列表中hashCode() 的作用是获取对象的散列码，
        进而确定该对象在散列表中的位置，当对象不会用来创建像hashMap、hashSet等散列表时，hashCode()实际上用不上
        1.若重写了equals(Object obj)方法，则有必要重写hashCode()方法。
        2.若两个对象equals(Object obj)返回true，则hashCode（）有必要也返回相同的int数。
        3.若两个对象equals(Object obj)返回false，则hashCode（）不一定返回不同的int数。
        4.若两个对象hashCode（）返回相同int数，则equals（Object obj）不一定返回true。
        5.若两个对象hashCode（）返回不同int数，则equals（Object obj）一定返回false。
            *否则会导致数据在hashSet或hashMap中数据的不一致性
        6.同一对象在执行期间若已经存储在集合中，则不能修改影响hashCode值的相关信息，否则会导致内存泄露问题。

* */
public class BaseType {
    static public void testEqual(){
          int a = 1;
        int b = 1;


        Integer c = 128;
        Integer d = 128;                    // 虽然需要装箱 但值比127大
        Integer e = Integer.valueOf(12);
        Integer f = 12;                     // 需要装箱  实质调用的是Integer.valueOf
        Integer h = new Integer(12);
        Integer i = new Integer(12);
        System.out.println(a == b);
        System.out.println( c == d);     // 输出来为false
        System.out.println(e == f);     // 输出来为true  在-128和127之间 比的是缓存对象
        System.out.println(h == i);     // 输出为false
        System.out.println(c.equals(d));// 输出为true
    }

    static public void hashTest(){
        Object o = new Object();
        o.hashCode();
        P1 p1 = new P1(12);
        P2 p2 = new P2(12);
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());

    }

    public static void main(String[] args) {
        hashTest();
        testEqual();
    }

    static class P1{
        public P1(int age) {
            this.age = age;
        }

        private int age;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            P1 p1 = (P1) o;
            return age == p1.age;
        }

        @Override
        public int hashCode() {
            return Objects.hash(age);
        }
    }

    static class P2{
        static int i = 0;
        private int age;

        public P2(int age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            P2 p2 = (P2) o;
            return age == p2.age;
        }

    }
}
