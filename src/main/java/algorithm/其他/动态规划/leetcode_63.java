package algorithm.其他.动态规划;

/**
 * 63. 不同路径 II  动态规划
 * @author zhouxianghui6
 * @description
 * @date 2025/2/8
 */
public class leetcode_63 {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int xl = obstacleGrid.length;
        int yl = obstacleGrid[0].length;
        if (obstacleGrid[xl-1][yl-1] == 1){
            return 0;
        }
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        int[][] grid = new int[xl][yl];
        for (int i = 0; i < xl; i++) {
            for (int j = 0; j < yl; j++) {
                if (i == 0 && j == 0){
                    grid[i][j] = 1;
                }
                if (i>0 && j>0){
                    if(obstacleGrid[i-1][j] == 1 && obstacleGrid[i][j-1] != 1){
                        grid[i][j] =grid[i][j-1];
                    }else if(obstacleGrid[i][j-1] == 1 && obstacleGrid[i-1][j] != 1){
                        grid[i][j] = grid[i-1][j];
                    }else if (obstacleGrid[i][j-1] != 1 && obstacleGrid[i-1][j] != 1){
                        grid[i][j] = grid[i-1][j] + grid[i][j-1];
                    }else {
                        grid[i][j]=0;
                    }
                }
                if (i == 0 && j!=0){
                    if (obstacleGrid[i][j]!=1){
                        grid[i][j] = grid[i][j-1];
                    }else {
                        grid[i][j] = 0;
                    }
                }
                if (j == 0 && i!=0){
                    if (obstacleGrid[i][j]!=1){
                        grid[i][j] = grid[i-1][j];
                    }else {
                        grid[i][j] = 0;
                    }
                }
            }
        }
        return  grid[xl-1][yl-1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        int i = uniquePathsWithObstacles(obstacleGrid);
        System.out.println();
    }
}
