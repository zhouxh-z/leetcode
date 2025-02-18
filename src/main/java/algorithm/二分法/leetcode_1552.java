package algorithm.二分法;

import java.util.Arrays;

/**
 * @author zhouxianghui6
 * @description
 * @date 2025/2/14
 */
public class leetcode_1552 {

    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int min = 1;
        int max = position[position.length - 1] - position[0];
        int ans = 0;
        while (min <= max){
            int mid = (max + min) / 2 ;
            int pre = position[0];
            int index = 1;
            for (int i = 1; i < position.length; i++) {
                if (pre + mid <= position[i]){
                    pre = position[i];
                    index ++;
                }
            }
            if(index >= m){
                min = mid+1;
                ans = mid;
            }else {
                max = mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        maxDistance(new int[]{79,74,57,22},4);
    }
}
