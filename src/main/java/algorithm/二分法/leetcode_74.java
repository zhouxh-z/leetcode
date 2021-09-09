package algorithm.二分法;

/**
 * 编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhouxh-z
 * @date 2021/9/8 14:52
 */
public class leetcode_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int y = matrix.length;
        int x = matrix[0].length;
        int low = 0;
        int length = y*x;
        int mid = (length+low) / 2;
        int midY = mid / x;
        int midX = mid % x;
        while (low>=0 && low<=length&&midX<x&&midY<y){
            if(matrix[midY][midX]>target){
                length = mid-1;
                mid = (length+low) / 2;
                midX = mid % x;
                midY = mid / x;
            }else if(matrix[midY][midX]<target){
                low = mid+1;
                mid = (length+low) / 2;
                midX = mid % x;
                midY = mid / x;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        leetcode_74 l = new leetcode_74();
        l.searchMatrix(new int[][]{{1}},3);
    }
}
