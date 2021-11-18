package algorithm.其他;

/**
 * 给你一个数组points，其中points[i] = [xi, yi]，表示第i个点在二维平面上的坐标。多个点可能会有 相同的坐标。
 *
 * 同时给你一个数组queries，其中queries[j] = [xj, yj, rj]，表示一个圆心在(xj, yj)且半径为rj的圆。
 *
 * 对于每一个查询queries[j]，计算在第 j个圆 内点的数目。如果一个点在圆的 边界上，我们同样认为它在圆内。
 *
 * 请你返回一个数组answer，其中answer[j]是第j个查询的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queries-on-number-of-points-inside-a-circle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author zhouxh-z
 * @date 2021/11/16 14:28
 */
public class leetcode_1828 {

    public int[] countPoints(int[][] points, int[][] queries) {
        int [] ans = new int[queries.length];
        for (int j = 0; j < queries.length ; j++) {
            int count = 0;
            Integer rj = queries[j][2];
            int xj = queries[j][0];
            int yj = queries[j][1];
            for (int i = 0; i < points.length; i++) {
                int[] point = points[i];
                int x = point[0];
                int y = point[1];
                if ((x-xj)*(x-xj) + (y-yj)*(y-yj) <= rj * rj) {
                    count++;
                }
            }
            ans[j] = count;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] points = new int[][] {{1,3},{3,3},{5,3},{2,2}};
        int[][] queries = new int[][] {{2,3,1},{4,3,1},{1,1,2}};
        leetcode_1828 l = new leetcode_1828();
        l.countPoints(points,queries);
    }
}
