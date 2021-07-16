package com.leetcode;

public class ZStr {
    // 第6题
    static public String zStr(String s, int num){
        if(s.length() == 1)
            return s;

        char[] chars = s.toCharArray();
        int rows = Math.min(num, s.length());
        StringBuffer[] buffers = new StringBuffer[rows];
        for(int i = 0; i < rows; i++)
            buffers[i] = new StringBuffer();
        StringBuffer res = new StringBuffer();
        int len = s.length();
        int row = 0;
        boolean isDown = false;


        for(int i = 0; i < len; i++){
            buffers[row].append(chars[i]);

            if(row == 0 || row == num - 1){
                isDown = !isDown;
            }

            row += isDown? 1: -1;
        }

        for (int i = 0; i < num; i++){
            res.append(buffers[i]);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int num = 3;
        String res = zStr(s, num);
        System.out.println(res);
    }

}
