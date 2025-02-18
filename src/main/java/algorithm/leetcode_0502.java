package algorithm;

/**
 *
 * 二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。如果该数字无法精确地用32位以内的二进制表示，则打印“ERROR”。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/bianry-number-to-string-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author zhouxianghui6
 * @description
 * @date 2023/3/2
 */
public class leetcode_0502 {

    public static String printBin(double num) {
        StringBuilder rtn = new StringBuilder("0.");
        while (rtn.length()<32){
            if (num * 2>=1) {
                rtn.append("1");
                num = num * 2 - 1;
            }else {
                rtn.append("0");
                num = num * 2;
            }
            if (num == 0){
                return rtn.toString();
            }
        }
        return "ERROR";
    }

    public static void main(String[] args) {
        printBin(0.625);
    }
}
