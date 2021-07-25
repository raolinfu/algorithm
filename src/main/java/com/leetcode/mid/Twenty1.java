package com.leetcode.mid;

import java.util.*;

public class Twenty1 {

    // 第6题
    static public String zStr(String s, int num) {
        if (s.length() == 1)
            return s;

        char[] chars = s.toCharArray();
        int rows = Math.min(num, s.length());
        StringBuffer[] buffers = new StringBuffer[rows];
        for (int i = 0; i < rows; i++)
            buffers[i] = new StringBuffer();
        StringBuffer res = new StringBuffer();
        int len = s.length();
        int row = 0;
        boolean isDown = false;


        for (int i = 0; i < len; i++) {
            buffers[row].append(chars[i]);

            if (row == 0 || row == num - 1) {
                isDown = !isDown;
            }

            row += isDown ? 1 : -1;
        }

        for (int i = 0; i < num; i++) {
            res.append(buffers[i]);
        }

        return res.toString();
    }

    // 第8题 字符串转换整数
    static public int str2Int(String str){
        String s = str.trim();
        if (s.length() == 0
                || (s.charAt(0) != '-'
                && s.charAt(0) != '+'
                && !Character.isDigit(s.charAt(0))))
            return 0;

        boolean neg = s.charAt(0) == '-'? true: false;
        int i = Character.isDigit(s.charAt(0))? 0: 1;
        long ans = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))){
            ans = ans * 10 + (s.charAt(i) - '0');
            if( !neg && ans > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            // 注意这里要用1L 否则是Int类型相加就溢出了 值就为负值了
            if( neg && (ans > (Integer.MAX_VALUE + 1L)) )
                return Integer.MIN_VALUE;

            i++;
        }

        return (int) (neg? -ans: ans);
    }

    // 11题 盛最多水的容器
    public int getMaxVolume(int[] nums){
        int volume = Integer.MIN_VALUE;
        int l = 0;
        int r = nums.length - 1;

        while (l < r){
            int v = Math.min(nums[l], nums[r]) * (r - l);
            volume = volume > v? volume: v;
            if(nums[l] > nums[r])
                r--;
            else
                l++;
        }

        return volume;
    }

    // 15 三数之和 a + b + c = 0  分成两数之和
    public List<List<Integer>> getTreeSum(Integer[] nums){
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int i = 0;
        while ( i < nums.length){
            getTwoSum(nums, i + 1, nums.length - 1, -nums[i], list);
            while ( i < nums.length -1 && nums[i] == nums[i + 1])
                i++;
        }
        
        return list;

    }

    public List<List<Integer>> getTwoSum(Integer[] nums, int l, int r, Integer tar, List<List<Integer>> list){
        while (l < r){
            if(nums[l] + nums[r] == tar){
                List<Integer> nl = new ArrayList<>(Arrays.asList(-tar, nums[l], nums[r]));
                list.add(nl);
            }

            while (l < r && nums[l + 1] == nums[l])
                l++;
            while (l < r && nums[r - 1] == nums[r])
                r--;
        }

        return list;
    }



    // 16 最接近的三数之和
    
    
    // 17电话号码字母组合
    public List<String> phoneNumCom(String str){
        Map<Character, String> map = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
        };
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        getCom(map, 0, sb, str, res);

        return res;
    }

    public void getCom(Map<Character, String> map, int index, StringBuilder sb, String str, List< String> res ){
        if(index == str.length())
        {
            res.add(sb.toString());
            return;
        }else {
            String s = map.get(str.charAt(index));
            for(int i = 0; i < s.length(); i++){
                sb.append(s.charAt(i));
                getCom(map, index + 1, sb, str, res);
                sb.deleteCharAt(index);
            }

        }
    }

    // 22括号生成
    static public List<String> getKuoHao(int n){
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        processKuoHao(list, sb, n , 0, 0);

        return list;
    }

    static public void processKuoHao(List<String> list, StringBuilder sb, int n, int l, int r){
        if( l == r && l == n){
            list.add(sb.toString());
            return;
        }

        if( l < n){
            sb.append('(');
            processKuoHao(list, sb, n, l + 1, r);
            // 注意这里的长度
            sb.deleteCharAt(sb.length() - 1);
        }

        if(r < l ){
            sb.append(')');
            processKuoHao(list, sb, n, l, r + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }


    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE + 1);
        int ans = str2Int("-42");
        System.out.println(ans);

        StringBuilder sb = new StringBuilder("abc");
        sb.deleteCharAt(1);
        System.out.println(sb);

        List<String> l = getKuoHao(3);
        for (int i = 0; i < l.size(); i++){
            System.out.println(l.get(i));
        }

    }
}
