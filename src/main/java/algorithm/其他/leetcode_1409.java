package algorithm.其他;

/**
 * 给你一个待查数组 queries ，数组中的元素为 1 到 m 之间的正整数。 请你根据以下规则处理所有待查项 queries[i]（从 i=0 到 i=queries.length-1）：
 *
 * 一开始，排列 P=[1,2,3,...,m]。
 * 对于当前的 i ，请你找出待查项 queries[i] 在排列 P 中的位置（下标从 0 开始），然后将其从原位置移动到排列 P 的起始位置（即下标为 0 处）。注意， queries[i] 在 P 中的位置就是
 * queries[i] 的查询结果。
 * 请你以数组形式返回待查数组  queries 的查询结果。
 *
 * 示例 1：
 *
 * 输入：queries = [3,1,2,1], m = 5
 * 输出：[2,1,2,1]
 * 解释：待查数组 queries 处理如下：
 * 对于 i=0: queries[i]=3, P=[1,2,3,4,5], 3 在 P 中的位置是 2，接着我们把 3 移动到 P 的起始位置，得到 P=[3,1,2,4,5] 。
 * 对于 i=1: queries[i]=1, P=[3,1,2,4,5], 1 在 P 中的位置是 1，接着我们把 1 移动到 P 的起始位置，得到 P=[1,3,2,4,5] 。
 * 对于 i=2: queries[i]=2, P=[1,3,2,4,5], 2 在 P 中的位置是 2，接着我们把 2 移动到 P 的起始位置，得到 P=[2,1,3,4,5] 。
 * 对于 i=3: queries[i]=1, P=[2,1,3,4,5], 1 在 P 中的位置是 1，接着我们把 1 移动到 P 的起始位置，得到 P=[1,2,3,4,5] 。
 * 因此，返回的结果数组为 [2,1,2,1] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queries-on-a-permutation-with-key
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queries-on-a-permutation-with-key
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhouxh-z
 * @date 2021/9/29 17:47
 */
public class leetcode_1409 {
    public int[] processQueries(int[] queries, int m) {
        int[] rtn = new int[queries.length];
        int[] base = new int[m];
        for (int i = 0; i < m ; i++) {
            base[i] = i+1;
        }
        int rtnIndex = 0;
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            int j = 0;
            while (query != base[j]){
                j++;
            }
            if(query == base[j]){
                rtn[rtnIndex] = j;
                rtnIndex++;
                int temp = base[j];
                int index = j;
                while (index>0){
                    base[index] = base[index-1];
                    index--;
                }
                base[0] = temp;
            }
        }
        return rtn;
    }

    public static void main(String[] args) {
        final leetcode_1409 leetcode_1409 = new leetcode_1409();
        System.out.println(leetcode_1409.processQueries(new int[]{4, 1, 2, 2}, 4));
    }
}
