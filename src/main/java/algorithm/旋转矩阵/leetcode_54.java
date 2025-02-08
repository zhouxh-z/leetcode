package algorithm.旋转矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 54 螺旋矩阵
 * @author zhouxianghui6
 * @description
 * @date 2025/2/8
 */
public class leetcode_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int x=0,y=0;
        int xl = matrix.length;
        int yl = matrix[0].length;
        boolean xa = false,xf = false,ya=true,yf = false;
        while (y< yl && x< xl){
            if (matrix[x][y]!=-101){
                list.add(matrix[x][y]);
            }
            matrix[x][y] = -101;
            if((y==yl-1 || (y< yl-1 && matrix[x][y+1] == 0)) && ya){
                ya = false;
                xa = true;
            }
            if((x==xl-1 || (x< xl-1 && matrix[x+1][y] == 0)) && xa){
                xa = false;
                yf = true;
            }
            if((y == 0 || (y>0 && matrix[x][y-1] == 0)) && yf){
                yf = false;
                xf = true;
            }
            if((x==0 || (x >0 && matrix[x-1][y] == 0)) && xf){
                xf = false;
                ya = true;
            }

            if(xa){
                x++;
            }
            if (xf){
                x--;
            }
            if(ya){
                y++;
            }
            if (yf){
                y--;
            }

        }

        return list;
    }
}
