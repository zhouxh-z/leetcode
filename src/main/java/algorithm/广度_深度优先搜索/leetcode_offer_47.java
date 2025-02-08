package algorithm.广度_深度优先搜索;

/**
 *
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，
 * 并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhouxianghui6
 * @description
 * @date 2023/3/8
 */
public class leetcode_offer_47 {
    /**
     * 二维动态规划
     *
     * ans[i,j] = MAX(ans[i-1,j],ans[i,j-1]) + grid[i,j]
     *
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        int y = grid.length;
        int x = grid[0].length;
        int[][] ans = new int[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                int max = 0;
                if (i>0){
                    max = Math.max(ans[i-1][j],max);
                }
                if(j>0){
                    max = Math.max(ans[i][j-1],max);
                }
                ans[i][j] = max + grid[i][j];
            }
        }
        return ans[y-1][x-1];
    }

}
