package algorithm;

/**
 * 1605. 给定行和列的和求可行矩阵
 *
 * @author zhouxianghui6
 * @description
 * @date 2023/3/14
 */
public class leetcode_1605 {

    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] rtn = new int[rowSum.length][colSum.length];
        for(int i = 0 ; i< rowSum.length;i++ ) {
            for (int j = 0; j < colSum.length; j++) {
                rtn[i][j] = -1;
            }
        }
        int[] cSum = new int[colSum.length];
        int[] rSum = new int[rowSum.length];
        for(int i = 0 ; i< rowSum.length;i++ ){
            for(int j = 0; j<colSum.length; j++){
                if(rtn[i][j] != -1){
                    continue;
                }
                if(i == 0 && j == 0){
                    if(rowSum[i]>=colSum[j]){
                        rtn[i][j] = colSum[j];
                        int index = i+1;
                        while (index<rowSum.length){
                            rtn[index][j] = 0;
                            index++;
                        }
                    }else {
                        rtn[i][j] = rowSum[i];
                        int index = j+1;
                        while (index<colSum.length){
                            rtn[i][index] = 0;
                            index++;
                        }
                    }
                    rSum[i] += rtn[i][j];
                    cSum[j] += rtn[i][j];
                    continue;
                }
                int row = rowSum[i] - rSum[i];
                int col = colSum[j] - cSum[j];
                rtn[i][j] = Math.min(row, col);
                if(row>=col){
                    rtn[i][j] = col;
                    int index = i+1;
                    while (index<rowSum.length){
                        rtn[index][j] = 0;
                        index++;
                    }
                }else {
                    rtn[i][j] = row;
                    int index = j+1;
                    while (index<colSum.length){
                        rtn[i][index] = 0;
                        index++;
                    }
                }
                rSum[i] +=  rtn[i][j];
                cSum[j] += rtn[i][j];
            }

        }
        return rtn;
    }

    public static void main(String[] args) {
        restoreMatrix(new int[]{5,7,10},new int[]{8,6,8});
    }
}
