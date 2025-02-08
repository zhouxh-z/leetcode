package algorithm;

/**
 * 给你一个m x n的矩阵mat和一个整数 k ，请你返回一个矩阵 answer，其中每个answer[i][j]是所有满足下述条件的元素mat[r][c] 的和：
 *  [[1,2,3,1,2,3],
 *   [4,5,6,4,5,6],
 *   [7,8,9,4,5,6],
 *   [1,2,3,1,2,3],
 *   [1,2,3,1,2,3]]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/matrix-block-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @ClassName algorithm
 * @Description:
 * @Author zhouxianghui6
 * @Date 2022/4/24 17:37
 * @since
 **/
public class leetcode_1314 {

    public static int[][] matrixBlockSum(int[][] mat, int k) {
        if(k == 0){
            return mat;
        }
        int m = mat.length;
        int n = mat[0].length;
        int [][] answer = new int[m][n];
        for (int i = -k; i <= k; i++) {
            for (int j = -k; j <= k; j++) {
                if(i>=0&&i< m && j>=0 && j< n){
                    answer[0][0] += mat[i][j];
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 && j == 0){
                    continue;
                }
                if(j-1 < 0){
                    // 点位下移
                    int x = 0;
                    for (int l = -k; l < k; l++) {
                        if(i-k-1>=0 && i-k-1< m && j-l>=0 && j-l<=n){
                            x += mat[i-k-1][j-l];
                        }
                        if(i+k>=0 && i+k< m && j-l>=0 && j-l<=n){
                            x -= mat[i+k][j-l];
                        }
                    }
                    answer[i][j] = answer[i-1][j] - x;
                }else {
                    // 点位右移
                    int x = 0;
                    for (int l = -k; l < k; l++) {
                        if(i-l>=0 && i-l< m && j-k-1>=0 && j-k-1<n){
                            x += mat[i-l][j-k-1];
                        }
                        if(i-l>=0 && i-l< m && j+k>=0 && j+k<n){
                            x -= mat[i-l][j+k];
                        }
                    }
                    answer[i][j] = answer[i][j-1] - x;
                }
            }
        }
        return answer;
    }
 // [[12,21,16],[27,45,33],[24,39,28]]
    public static void main(String[] args) {
        matrixBlockSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}},1);
    }
}
