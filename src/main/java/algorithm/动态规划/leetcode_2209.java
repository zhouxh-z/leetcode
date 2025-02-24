package algorithm.动态规划;

/**
 * @author zhouxianghui6
 * @description
 * @date 2025/2/21
 */
public class leetcode_2209 {

    public static int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        char[] chars = floor.toCharArray();
        int [][] dp = new int[chars.length][numCarpets];

        for (int i = 1; i < chars.length; i++) {
            for (int j = 1; j < numCarpets; j++) {
                // 当前位置不放
                dp[i][j] = dp[i-1][j] + (chars[i] == '1' ? 1:0);
                // 当前位置放
                int index = i - carpetLen;
                if (index<0){
                    index = 0;
                }
                dp[i][j] =Math.min(dp[i][j],dp[index][j-1]);
            }
        }

        return dp[chars.length-1][carpetLen];
    }


    public static void main(String[] args) {
        minimumWhiteTiles("10110101",2,2);
    }
}
