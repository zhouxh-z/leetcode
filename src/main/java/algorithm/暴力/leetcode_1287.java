package algorithm.暴力;

/**
 * @author zhouxianghui6
 * @description
 * @date 2025/2/17
 */
public class leetcode_1287 {

    public static int findSpecialInteger(int[] arr) {
        int m = arr.length / 4;
        int num = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[i+1]){
                num ++;
            }else {
                num = 1;
            }
            if (num> m) {
                return arr[i];
            }
        }
        return arr[0];
    }

    public static void main(String[] args) {
        findSpecialInteger(new int[]{1,2,2,6,6,6,6,7,10});
    }
}