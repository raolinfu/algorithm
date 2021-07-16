package com.rao.string;

public class UniqueChar {
    // 判断字符串中字符是否唯一
    static public boolean isUnique(String str){
        if(str == null)
            return true;
        char[] chars = str.toCharArray();
        boolean[] map = new boolean[256];

        for (int i = 0; i < chars.length; i++){
            if(map[chars[i]] == true)
                return false;
            map[chars[i]] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "abca";
        System.out.println(isUnique(str));
    }

}
