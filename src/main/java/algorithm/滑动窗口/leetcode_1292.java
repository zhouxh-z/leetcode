package algorithm.滑动窗口;

/**
 * 给你一个大小为m x n的矩阵mat和一个整数阈值threshold。
 *
 * 请你返回元素总和小于或等于阈值的正方形区域的最大边长；如果没有这样的正方形区域，则返回 0。
 *
 * 输入：mat = [[1,1,3,2,4,3,2]
 *            ,[1,1,3,2,4,3,2]
 *            ,[1,1,3,2,4,3,2]], threshold = 4
 * 输出：2
 * 解释：总和小于或等于 4 的正方形的最大边长为 2，如图所示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_1292 {
    public static int maxSideLength(int[][] mat, int threshold) {
        // 先根据矩阵生成二维矩阵和
        int[][] ints = toSum(mat);

        // 判断最大的正方形边长是多少
        int y = mat.length;
        int x = mat[0].length;
        int min = Math.min(y, x);

        // 从大到小判断 符合条件的最大边长是多少
        for (int i = min; i > 0; i--) {
            // x 轴
            for (int j = i-1; j < x; j++) {
                // y 轴
                for (int k = i-1; k < y; k++) {
                    int i1 =j - i<0?0:ints[k][j - i];
                    int i2 =k - i<0?0: ints[k - i][j];
                    int i3 =j - i<0 || k - i<0?0:ints[k - i][j - i];
                    int sum = ints[k][j] - i1 - i2 + i3;
                    if(sum<=threshold){
                        return i;
                    }
                }
            }
        }

        return 0;
    }
    public static int[][] toSum(int[][] mat){
        int[][] rtn = new int[mat.length][mat[0].length];
        // y
        for (int i = 0; i < mat.length; i++) {
            int first = 0;
            // x
            for (int j = 0; j < mat[i].length; j++) {
                int i1 = i - 1<0?0:rtn[i - 1][j];
                int i2 = j - 1<0?0:rtn[i][j - 1];
                int i3 = i - 1<0 || j - 1<0?0:rtn[i - 1][j - 1];
                rtn[i][j] = mat[i][j] + i1 + i2 - i3;
            }
        }
        return rtn;
    }
    public static void main(String[] args) {
        int[] ints = {1, 2};
        int[] ints1 = {2, 2};
        int[][] ints2 = {ints, ints1, ints1,ints1,ints1};
//        int[][] ints2 = new int[][]{
//                 {21,91}
//                ,{67,74}
//                ,{24,73}
//                ,{81,27}
//                ,{21,81}
//                ,{64,69}
//                ,{2,3}
//                ,{6,8}
//                ,{28,57}
//                ,{66,41}};
        int i = maxSideLength(ints2, 1);
        System.out.println(i);
    }
}
