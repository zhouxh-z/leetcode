package algorithm.位运算;

/**
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 * @author zhouxh_z
 */
public class leetcode_191 {
    /**
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        if(n == 0 ){
            return 0;
        }
        int times = 0;
        while ((n&n-1) != 0){
            times++;
            n = n&n-1;
        }
        return times+1;
    }

    public static void main(String[] args) {
        leetcode_191 l = new leetcode_191();
        l.hammingWeight(11);
    }
}
