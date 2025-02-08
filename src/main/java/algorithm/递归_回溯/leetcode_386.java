package algorithm.递归_回溯;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
 *
 * 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
 *
 *
 *
 * @ClassName algorithm
 * @Description:
 * @Author zhouxianghui6
 * @Date 2022/4/18 11:35
 * @since
 **/
public class leetcode_386 {

    public static List<Integer> lexicalOrder(int n) {
        List<Integer> rtn = new ArrayList<>();
        int start = 1;
        lexicalOrder(start,rtn,n);
        return  rtn;
    }

    public static void lexicalOrder(int index,List<Integer> rtn,int n){
        if(index>n){
            return;
        }
        if(index%10==0){
            if(rtn.size()>0){
                Integer before = rtn.get(rtn.size() - 1);
                if(before*10!=index){
                    return;
                }
            }
        }

        rtn.add(index);

        // 乘 10
        index = index * 10;
        lexicalOrder(index,rtn,n);
        index = index / 10;
        // 加 1
        if(index==9){
           return;
        }
        index = index+1;
        lexicalOrder(index,rtn,n);
    }

    public static void main(String[] args) {
        lexicalOrder(2000000);
    }
}
