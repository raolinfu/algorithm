package com.rao.dynamic;

/*
* 机器人走路 暴力解法和动态昭规划
*   共有1~N个位置  给定机器人的初始位置B 以及步数R 求能直到位置F的解法
*  分析：位置在1处 只能往2走
*       位置在N处   只能往N-1走
*       位置在中间I处  能往I-1或I+1走
* */
public class RobotPath {
    // 递归
    static public int getPathNum(int b, int r, int f, int n){
        return process( b,  r,  f,  n);
    }
    static public int process(int b, int r, int f, int n){
        if(r == 0)
            return b == f? 1: 0;
        if (b == 1)
            return process(2, r - 1, f, n);
        if (b == n)
            return process(n - 1, r - 1, f, n);

        return process(b + 1, r - 1, f, n) + process(b - 1, r - 1, f, n);
    }

    // 动态规划
    /*
     * 位置在I 步数为S 最终到达F的次数是无状态的 需要求解dp[B][R]
     * 1、 I的范围是1~N
     * 2、 S的范围是0~R
     * dp[S][I]表示初始位置I，步数为S，最终到达F的总类数
    */
    static public int getPathDynamic(int b, int r, int f, int n){
        int [][] dp = new int[r + 1][n + 1];
        // 第一行 步数为0 位置在1到n处
        dp[0][f] = 1;
        /*
        *   位置在1处   dp[r][1] = dp[r - 1][2]
        *   位置在n处   dp[r][n] = dp[r - 1][n - 1]
        *   其它位置    dp[r][i] = dp[r - 1][i + 1] + dp[r - 1][i - 1]
        *   dp结果都是依赖于上一行  只要得到第一行 则可以推理下来
        * */
        for(int i = 1; i <= r; i++ ){
            for(int j = 1; j <= n; j++){
                if (j == 1)
                    dp[i][j] = dp[i - 1][2];
                else if(j == n)
                    dp[i][j] = dp[i - 1][n - 1];
                else dp[i][j] = dp[i - 1][j + 1] + dp[i - 1][j - 1];
            }
        }

        return dp[r][b];
    }

    // 动态规划空间压缩技巧
    static public int getPathDynamicLessSpace(int b, int r, int f, int n){
        int[] dp = new int[n + 1];
        dp[f] = 0;

        for(int i = 1; i <= r; i++){
            int leftUp = dp[1]; //左上角的值
            for(int j = 1; j <= n; j++){
                int tmp = dp[j];
                if(j == 1)
                    dp[j] = dp[2];
                else if(j == n)
                    dp[j] = dp[n - 1];
                else dp[j] = leftUp + dp[j + 1];
                leftUp = tmp;
            }
        }

        return dp[b];
    }
}
