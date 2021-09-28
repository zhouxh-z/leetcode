package algorithm.其他;

/**
 * 在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 *
 * 给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
 * @author zhouxh-z
 * @date 2021/9/28 11:06
 */
public class leetcode_779 {
    // 其实最终这个字符还是由 0110 反复取反得到的
    // 0110 取反 1001
    public int kthGrammar(int n, int k) {
        int times = 0;
        while (n>1){
            // 第n行的总数
            int i = 1 << n;
            // 是否超过半数，如果半数以上，对称 times 记录一次
            if(k > i/2){
                k = k - i/2;
                times ++;
            }
            n --;
        }
        int[] base = new int[]{0,1};
        if(times % 2 == 0){
            return base[k-1];
        }else {
            if(base[k-1] == 0){
                return 1;
            }
            return 0;
        }
    }



    public static void main(String[] args) {
        leetcode_779 l = new leetcode_779();
        System.out.println(l.kthGrammar(4, 12));
    }
}
