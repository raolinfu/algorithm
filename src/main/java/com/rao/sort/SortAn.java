package com.rao.sort;
/*
* 各种上排序算法
* */

public class SortAn {
    // 冒泡排序

    // 插入排序
    static public void InsertionSort(int[] a, int len)
    {
        for (int j=1; j<len; j++)
        {
            int key = a[j];
            int i = j-1;
            while (i>=0 && a[i]>key)
            {
                a[i+1] = a[i];
                i--;
            }
            a[i+1] = key;
        }
    }

    // 快速排序算法
    static public void quickSort(int[] arr,int begin,int end)
    {
        //如果区间不只一个数
        if(begin < end)
        {
            int temp = arr[begin]; //将区间的第一个数作为基准数
            int i = begin; //从左到右进行查找时的“指针”，指示当前左位置
            int j = end; //从右到左进行查找时的“指针”，指示当前右位置
            //不重复遍历
            while(i < j)
            {
                //当右边的数大于基准数时，略过，继续向左查找
                //不满足条件时跳出循环，此时的j对应的元素是小于基准元素的
                while(i<j && arr[j] > temp)
                    j--;
                //将右边小于等于基准元素的数填入右边相应位置
                arr[i] = arr[j];
                //当左边的数小于等于基准数时，略过，继续向右查找
                //(重复的基准元素集合到左区间)
                //不满足条件时跳出循环，此时的i对应的元素是大于等于基准元素的
                while(i<j && arr[i] <= temp)
                    i++;
                //将左边大于基准元素的数填入左边相应位置
                arr[j] = arr[i];
            }
            //将基准元素填入相应位置
            arr[i] = temp;
            //此时的i即为基准元素的位置
            //对基准元素的左边子区间进行相似的快速排序
            quickSort(arr,begin,i-1);
            //对基准元素的右边子区间进行相似的快速排序
            quickSort(arr,i+1,end);
        }
        //如果区间只有一个数，则返回
        else
            return;
    }

    // 归并排序

    // 堆排序


}
