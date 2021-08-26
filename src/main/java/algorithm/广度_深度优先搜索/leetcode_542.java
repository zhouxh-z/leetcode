package algorithm.广度_深度优先搜索;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个由 0 和 1 组成的矩阵 mat，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 *
 * 输入：mat = [[0,0,0]
 *            ,[0,1,0]
 *            ,[0,0,0]]
 * 输出：[[0,0,0]
 *      ,[0,1,0]
 *      ,[0,0,0]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/01-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 广度优先搜索
 * @author zhouxh_z
 */
public class leetcode_542 {

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static int[][] updateMatrix(int[][] mat) {
        int x = mat.length , y = mat[0].length;
        int[][] rtnMat = new int[x][y];
        Queue<int[]> linkedList = new LinkedList<>();
        boolean[][] seen = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if(mat[i][j] == 0){
                    linkedList.add(new int[]{i, j});
                    seen[i][j] = true;
                }
            }
        }
        while (!linkedList.isEmpty()){
            int[] xy = linkedList.poll();
            int x_ = xy[0],y_ = xy[1];
            for (int i = 0; i < 4; i++) {
                int mx = x_ + dirs[i][0] , my = y_ + dirs[i][1];
                if(mx>=0 && my>=0 && mx<x && my<y && !seen[mx][my]){
                    rtnMat[mx][my] = 1 + rtnMat[x_][y_];
                    seen[mx][my] = true;
                    linkedList.add(new int[]{mx, my});
                }
            }
        }
        return rtnMat;
    }

    public static void main(String[] args) {
        updateMatrix(new int[][]{{0},{0},{0},{0},{0}});
    }



}
