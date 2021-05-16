package com.rao.dynamic;

public class Matrix {
    // 矩阵的最短路径和 空间复杂度为n*m做法
    static int minSum1(int[][] matrix) {
        int ret;
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length ==0)
            return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = matrix[0][0];

        // 第一行
        for (int i = 1; i < col; i++ ){
            dp[0][i] = matrix[0][i] + dp[0][i-1];
        }

        // 第一列
        for (int i = 1; i < row; i++)
            dp[i][0] = matrix[i][0] + dp[i - 1][0];

        for(int i = 1; i < row; i++){
            for (int j = 1; j < col; j++){
                dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[col - 1][row - 1];
    }

    // 空间复杂度为min(n, m)
    static public int minSum2(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length==0)
            return 0;
        int more = matrix.length > matrix[0].length? matrix.length: matrix[0].length;
        int less = matrix.length > matrix[0].length? matrix[0].length: matrix.length;
        boolean rowMore = more == matrix.length;

        int[] dp = new int[less];
        dp[0] = matrix[0][0];
        for (int i = 1; i < less; i++)
            dp[i] = dp[i - 1] + (rowMore? matrix[i][0]: matrix[0][i]);

        for(int i = 1; i < more; i++){
            dp[0] = dp[0] + (rowMore? matrix[0][i]: matrix[i][0]);
            for (int j = 1; j < less; j++){
                dp[j] = Math.min(dp[j - 1], dp[j]) + (rowMore? matrix[i][j]: matrix[j][i]);
            }
        }

        return dp[less -1];

    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 4}, {6, 11, 12}};
    }
}
