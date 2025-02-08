package algorithm.滑动窗口;

/**
 * @author zhouxianghui6
 * @description
 * @date 2023/3/9
 */
public class leetcode_2379 {

    public static int minimumRecolors(String blocks, int k) {
        int left = 0;
        int right = k - 1;
        int min = 0;
        for (int i = 0; i <= right; i++) {
            if (blocks.charAt(i) == 'W') {
                min ++;
            }
        }
        int thisMin = min;
        while (right<blocks.length()-1){
            if (blocks.charAt(left) == 'W') {
                thisMin --;
            }
            if(blocks.charAt(right+1) == 'W'){
                thisMin ++;
            }
            min = Math.min(thisMin,min);
            right++;
            left++;
        }
        return min;
    }

    public static void main(String[] args) {
        minimumRecolors("BWBBWWBBBWBWWWBWWBBWBWBBWBB",
                11);
    }

}
