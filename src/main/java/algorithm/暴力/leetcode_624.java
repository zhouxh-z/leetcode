package algorithm.暴力;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zhouxianghui6
 * @description
 * @date 2025/2/19
 */
public class leetcode_624 {

    public static int maxDistance(List<List<Integer>> arrays) {
        int ans = 0;
        List<Integer> list1 = arrays.get(0);
        int min = list1.get(0);
        int max = list1.get(list1.size() - 1);
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> list = arrays.get(i);
            Integer integer = list.get(0);
            Integer integer1 = list.get(list.size() - 1);
            ans = Math.max(ans,Math.max(integer1 - min,max-integer));
            min = Math.min(integer,min);
            max = Math.max(integer1,max);

        }
        return ans;
    }

    public static void main(String[] args) {
        Integer [] ac = new Integer[]{-10,-9,-9,-3,-1,-1,0};

        List<Integer> a = new ArrayList<>();
        Collections.addAll(a,ac);
        List<Integer> b = new ArrayList<>();
        Integer [] bc = new Integer[]{-5};
        Collections.addAll(b,bc);
        List<Integer> c = new ArrayList<>();
        Integer [] cc = new Integer[]{4};
        Collections.addAll(c,cc);
        List<Integer> d = new ArrayList<>();
        Integer [] dc = new Integer[]{-8};
        Collections.addAll(d,dc);
        List<Integer> e = new ArrayList<>();
        Integer [] ec = new Integer[]{-9,-6,-5,-4,-2,2,3};
        Collections.addAll(e,ec);
        List<Integer> f= new ArrayList<>();
        Integer [] fc = new Integer[]{-3,-3,-2,-1,0};
        Collections.addAll(f,fc);

        List<List<Integer>> arrays = new ArrayList<>();
        arrays.add(a);
        arrays.add(b);
        arrays.add(c);
        arrays.add(d);
        arrays.add(e);
        arrays.add(f);
        maxDistance(arrays);
    }

}
