package algorithm.广度_深度优先搜索;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhouxh-z
 * @date 2021/10/8 10:34
 */
public class leetcode_240 {
    /**
     * 方法一 广度优先搜索
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0;i<matrix.length;i++){
            for (int j = 0; j < matrix[0].length; j++) {
                queue.add(new int[]{i,j});
            }
        }
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int matrix1 = matrix[poll[0]][poll[1]];
            if(matrix1 == target){
                return true;
            }
        }
        return false;
    }

    /**
     * 右上角 开始搜索
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        int x = 0, y = matrix[0].length-1;
        while (0<=x && x<matrix.length && y>=0 && y < matrix[0].length){
            int tmp = matrix[x][y];
            if(tmp == target){
                return true;
            }
            if(tmp>target){
                y--;
            }else {
                x++;
            }

        }
        return false;
    }
}