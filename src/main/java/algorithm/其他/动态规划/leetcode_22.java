package algorithm.其他.动态规划;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhouxianghui6
 * @description
 * @date 2025/2/10
 */
public class leetcode_22 {
    public static List<String> generateParenthesis(int n) {
        List<String> bb = new ArrayList<>();
        bb.add("()");
        for (int j = 1; j < n; j++) {
            Set<String> set = new HashSet<>();
            for (int i = 0; i < bb.size(); i++) {
                String s = bb.get(i);

            }
            bb.clear();
            bb.addAll(set);
        }
        return bb;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }
}
