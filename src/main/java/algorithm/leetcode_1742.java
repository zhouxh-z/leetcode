package algorithm;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouxianghui6
 * @description
 * @date 2025/2/13
 */
public class leetcode_1742 {

    public static int countBalls(int lowLimit, int highLimit) {
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for (int i = lowLimit; i <= highLimit ; i++) {
            int v = 0;
            int m = i;
            while (m>0){
                v += m % 10;
                m =  m / 10;
            }
            if (map.containsKey(v)) {
                map.put(v,map.get(v) + 1);
            }else {
                map.put(v,1);
            }
            max = Math.max(max,map.get(v));
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(countBalls(1,10));
    }
}
