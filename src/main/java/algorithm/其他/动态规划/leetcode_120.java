package algorithm.其他.动态规划;

import java.util.ArrayList;
import java.util.List;

public class leetcode_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        // 第i行 第j列 的 和
        final int size = triangle.size();
        int [][] f = new int[size][triangle.get(size -1).size()];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < size; i++) {
            List<Integer> integers = triangle.get(i);
            f[i][0] = f[i-1][0] + integers.get(0);
            for (int j = 1; j < integers.size(); j++) {
               f[i][j] = Math.min(f[i-1][j-1],f[i-1][j]) + integers.get(j);
            }
            f[i][integers.size()-1] = f[i-1][integers.size()-2]+ integers.get(integers.size()-1);
        }
         int min = f[size -1][0] ;
        for (int i = 1; i < size; i++) {
            min = Math.min(min,f[size -1][i]);
        }
        return min;
    }



    public int minimumTotal1(List<List<Integer>> triangle) {
        minimumTotal1(triangle,0,0,0);
        Integer integer = sumList.get(0);
        for (int i = 1; i < sumList.size(); i++) {
            integer = Math.min(integer,sumList.get(i));
        }
        return integer;
    }
    List<Integer> sumList = new ArrayList<>();
    public void minimumTotal1(List<List<Integer>> triangle,int i,int j, int sum){
        if(i>=triangle.size()){
            if(!sumList.contains(sum)){
                sumList.add(sum);
            }
            return;
        }
        if(j>=triangle.get(i).size()){
            if(!sumList.contains(sum)){
                sumList.add(sum);
            }
            return;
        }
        Integer integer = triangle.get(i).get(j);
        // 向左下走
        sum+=integer;
        minimumTotal1(triangle,i+1,j,sum);
        // 向右下走
        minimumTotal1(triangle,i+1,j+1,sum);
        sum-=integer;
        return;
    }





    public static void main(String[] args) {
        leetcode_120 l = new leetcode_120();
        List<List<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(2);
        lists.add(integers);
        ArrayList<Integer> integers1 = new ArrayList<>();
        integers1.add(3);
        integers1.add(4);
        ArrayList<Integer> integers2 = new ArrayList<>();
        integers2.add(6);
        integers2.add(5);
        integers2.add(7);
        ArrayList<Integer> integers23 = new ArrayList<>();
        integers2.add(4);
        integers2.add(1);
        integers2.add(8);
        integers2.add(3);
        lists.add(integers1);
        lists.add(integers2);
        l.minimumTotal1(lists);
    }
}
