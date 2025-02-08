package algorithm;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/jian-sheng-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_offer14_1 {

    public static int cuttingRope(int n) {
        int rtn = 1;
        if(n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        if(n == 4){
            return 4;
        }
        // 对3取余
        while (n>4){
            n -= 3;
            rtn *= 3;
        }
        rtn *= n;
        return rtn;
    }

    public static void main(String[] args) {
        System.out.println(cuttingRope(2));
        System.out.println(cuttingRope(8));
        System.out.println(cuttingRope(10));
    }

}
