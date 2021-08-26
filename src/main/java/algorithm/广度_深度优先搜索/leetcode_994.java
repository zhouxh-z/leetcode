package algorithm.广度_深度优先搜索;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 *
 * 值0代表空单元格；
 * 值1代表新鲜橘子；
 * 值2代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 *
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回-1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotting-oranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 *
 * 广度优先搜索
 * @author zhouxh_z
 */
public class leetcode_994 {

    public int orangesRotting(int[][] grid) {
        int[][] dir = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
        int x = grid.length,y = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int gridNum = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if(grid[i][j] == 2){
                    queue.add(new int[]{i, j,0});
                }
                if(grid[i][j] == 1){
                    gridNum++;
                }
            }
        }
        int num = 0;
        while (!queue.isEmpty()){
            int[] xy = queue.poll();
            int mx = xy[0],my = xy[1],time = xy[2];
            for (int i = 0; i < 4; i++) {
                int x_ = mx + dir[i][0],y_ = my+dir[i][1];
                if(x_>=0 && y_>=0 && x_< x && y_<y && grid[x_][y_]!=2){
                    if(grid[mx][my] == 1){
                        queue.add(new int[]{mx, my,time+1});
                        grid[mx][my] = 2;
                        gridNum --;
                    }
                }
            }
            num = time;
        }
        if(gridNum != 0){
            num = -1;
        }
        return num;
    }
}
