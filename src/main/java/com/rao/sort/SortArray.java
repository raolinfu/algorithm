package com.rao.sort;

public class SortArray {
    // 给定一个数组和一个数tar 使某个位置开始左边比tar小 右边比它大
    static public void midArray(int[] arr, int tar){
        if (arr == null)
            return;
        int i = 0;
        int j = arr.length - 1;

        while (i < j){
            int tmp = arr[i];
            if (arr[i] < tar){
                i++;
                continue;
            }
            arr[i] = arr[j];
            arr[j] = tmp;
            j--;
        }
    }

    // 改良上面 数组第一个数在中间
    static public void midFirstEle(int[] arr, int begin, int end){
        if (begin >= end)
            return;
        int i = begin;
        int j = end;
        int cmp = arr[i];
        while (i < j){
            int tmp = arr[i];
            if(arr[i] < cmp){
                i++;
                continue;
            }
            // 第一个元素与cmp相等 需要交换 即交换最后一个元素
            arr[i]=arr[j];
            arr[j]=tmp;
            j--;
        }

        int tmp = arr[j + 1];
        arr[j + 1] = arr[end];
        arr[end] = tmp;

    }

    public static void main(String[] args) {
        int[]  arr = {23, 3, 54, 6, 12};
        int tar = 7;
        for (int i  = 0; i < arr.length; i++)
            System.out.print(arr[i] + "\t");
        System.out.println();
        midArray(arr, tar);
        for (int i : arr)
            System.out.print(i + "\t");
        System.out.println();

        // 测试数组和第一个元素
        int[] arr1 = {12, 23};
        midFirstEle(arr1, 0, arr1.length - 1);
        for (int i : arr1)
            System.out.print(i + "\t");
        System.out.println();

    }
}
