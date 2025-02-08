package algorithm.旋转矩阵;

/**
 * @author zhouxianghui6
 * @description
 * @date 2025/2/7
 */
public class leetcode_59 {
    public static int[][] generateMatrix(int n) {
        int x = 0,y=0,num=1;
        // xa    x ++
        boolean xa = false,xf = false,ya=true,yf = false;
        int[][] matrix = new int[n][n];
        while (num <= n*n){
            if(matrix[x][y] == 0){
                matrix[x][y] = num;
            }

            if ((y == n-1 || ( y<n-1 && matrix[x][y+1] != 0)) && ya ){
                ya = false;
                xa = true;
            }

            if ((x == n-1 || ( x<n-1 && matrix[x+1][y] != 0)) && xa){
                yf = true;
                xa = false;
            }

            if ((y == 0 || ( y>0 && matrix[x][y-1] != 0)) && yf){
                yf = false;
                xf = true;
            }

            if ((x == 0 || (x>0 && matrix[x-1][y] != 0))&& xf ){
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
            num++;
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] ints = generateMatrix(1000);
        System.out.println(ints);
    }
}
