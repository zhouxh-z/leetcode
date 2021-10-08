package algorithm.其他;

/**
 * @author zhouxh-z
 * @date 2021/10/8 11:50
 */
public class leetcode_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx1 = m-1,idx2=n-1;
        int length1 = nums1.length;
        while (idx2>=0){
            if (idx1>=0 && nums1[idx1] > nums2[idx2]) {
                nums1[length1-1] = nums1[idx1];
                nums1[idx1] = 0;
                idx1 --;
                length1--;
            }else {
                nums1[length1-1] = nums2[idx2];
                idx2 --;
                length1--;
            }
        }
    }

    public static void main(String[] args) {
        leetcode_88 l = new leetcode_88();
        l.merge(new int[]{2,0},1,new int[]{1},1);
    }
}
