package algorithm.二分法;


import java.util.Arrays;

/**
 * @author zhouxianghui6
 * @description
 * @date 2025/2/12
 */
public class leetcode_1760 {

    public static int minimumSize(int[] nums, int maxOperations) {
        // 假设 最小开销是 y
        int max = Arrays.stream(nums).max().getAsInt();
        int min = 1 ;
        int ans = 0;
        while (min <= max){
            int y = (max+min)/2;
            int operation = 0;
            for (int j = 0; j < nums.length ; j++) {
                operation += (nums[j] - 1) / y;
            }
            if (operation <= maxOperations){
                max = y-1;
                ans = y;
            }else if (operation> maxOperations){
                min = y+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minimumSize(new int[]{9}, 200));
    }
}
