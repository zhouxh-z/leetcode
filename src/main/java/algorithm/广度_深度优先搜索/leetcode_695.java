package algorithm.广度_深度优先搜索;

/**
 * 给定一个包含了一些 0 和 1 的非空二维数组1grid 。
 *
 * 一个1岛屿1是由一些相邻的111(代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。
 * 你可以假设1grid 的四个边缘都被 0（代表水）包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-area-of-island
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 17826
 */
public class leetcode_695 {

    public int maxAreaOfIsland(int[][] grid) {
        int rtn = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                rtn = Math.max(rtn,maxAreaOfIsland(grid,i,j));
            }
        }
        return rtn;
    }
    public int maxAreaOfIsland(int[][] grid,int x,int y){
        if(x<0 || y<0 || x>= grid.length || y>=grid[0].length){
            return 0;
        }
        // 标记已经遍历的
        int rtn = 1;
        if(grid[x][y] == 0){
            return 0;
        }
        grid[x][y] = 0;
        int[] xVariable = new int[]{1,0,-1,0};
        int[] yVariable = new int[]{0,1,0,-1};
        for (int i = 0; i < 4; i++) {
            rtn  += maxAreaOfIsland(grid,x + xVariable[i],y + yVariable[i]);
        }
        return rtn;
    }
}
