package com.rao.string;

import java.util.Map;

public class ChangeStr {
    // 两个str是否互为变形词
    static public boolean isChangeStr(String str1, String str2){
        if(str1 == null || str2 == null)
            return false;
        else if(str1.length() != str2.length())
            return false;

        char[] arr = new char[256];
        for (char i : str1.toCharArray()){
            arr[i]++;
        }

        for (char i : str2.toCharArray())
            arr[i]--;

        for (char i : arr)
            if (arr[i] != 0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        String a = "abc";
        String b = "abc";
        System.out.println( isChangeStr("abcd", "dbca"));
    }
}
