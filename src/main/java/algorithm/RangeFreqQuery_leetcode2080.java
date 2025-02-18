package algorithm;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhouxianghui6
 * @description
 * @date 2025/2/18
 */
public class RangeFreqQuery_leetcode2080 {

    Map<Integer, List<Integer>> ansMap = new HashMap<>();

    public RangeFreqQuery_leetcode2080(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            if (ansMap.containsKey(key)) {
                List<Integer> indexs = ansMap.get(key);
                indexs.add(i);
                ansMap.put(key,indexs);
            }else {
                List<Integer> indexs = new ArrayList<>();
                indexs.add(i);
                ansMap.put(key,indexs);
            }
        }
    }

    public int query(int left, int right, int value) {
        if (!ansMap.containsKey(value)) {
            return 0;
        } else {
            List<Integer> indexs = ansMap.get(value);
            if (right<indexs.get(0)){
                return 0;
            }
            if (left>indexs.get(indexs.size() - 1)){
                return 0;
            }
            int low = query2(indexs, left,true);
            int hight = query3(indexs, right,false);

            return hight - low + 1 ;
        }
    }

    public int query2(List<Integer> indexs,int num,boolean f){
        int low =0;
        int hight = indexs.size() - 1;
        while (low <= hight){
            int mid = (low + hight) / 2;
            if (indexs.get(mid) >= num){
                hight = mid - 1;
            }else {
                low = mid + 1 ;
            }
        }
        return low;
    }

    public int query3(List<Integer> indexs,int num,boolean f){
        int low =0;
        int hight = indexs.size() - 1;
        while (low <= hight){
            int mid = (low + hight) / 2;
            if (indexs.get(mid) > num){
                hight = mid - 1;
            }else {
                low = mid + 1 ;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        RangeFreqQuery_leetcode2080 r = new RangeFreqQuery_leetcode2080(new int[]{3,4,5,3,3,2,2,2,5,4});
        System.out.println(r.query(2,6,3));

    }
}
