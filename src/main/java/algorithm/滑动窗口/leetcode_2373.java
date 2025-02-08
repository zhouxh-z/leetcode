package algorithm.滑动窗口;

import java.util.Arrays;

/**
 *
 * 给你一个大小为 n x n 的整数矩阵 grid 。
 *
 * 生成一个大小为 (n - 2) x (n - 2) 的整数矩阵  maxLocal ，并满足：
 *
 * maxLocal[i][j] 等于 grid 中以 i + 1 行和 j + 1 列为中心的 3 x 3 矩阵中的 最大值 。
 * 换句话说，我们希望找出 grid 中每个 3 x 3 矩阵中的最大值。
 *
 * 返回生成的矩阵。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/largest-local-values-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *  [[9,9,8,1],
 *  [5,6,2,6],
 *  [8,2,6,4],
 *  [6,2,2,2]]
 *
 *
 *
 * @author zhouxianghui6
 * @description
 * @date 2023/3/3
 */
public class leetcode_2373 {

    public int[][] largestLocal(int[][] grid) {
        int[][] ints = new int[grid.length - 2][grid[0].length - 2];
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                ints[i][j] = max(grid,i,j);
            }
        }
        return ints;
    }

    public int max(int[][] grid,int i,int j){
        // 3*3 的窗口
        int outMax = 0;
        for (int k = 0; k < 3; k++) {
            int inMax = 0;
            for (int l = 0; l < 3; l++) {
                inMax = Math.max(inMax,grid[i+k][j + l]);
            }
            outMax = Math.max(inMax, outMax);
        }
        return outMax;
    }

    public static void main(String[] args) {
        int[][] ints = {{9, 9, 8, 1}, {5, 6, 2, 6}, {8, 2, 6, 4}, {6, 2, 2, 2}};
        leetcode_2373 ll = new leetcode_2373();
        System.out.println(Arrays.deepToString(ll.largestLocal(ints)));
    }
}
