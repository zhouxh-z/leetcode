package algorithm.广度_深度优先搜索;

import java.util.LinkedList;
import java.util.List;

/**
 * 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
 *
 * 给你一个坐标(sr, sc)表示图像渲染开始的像素值（行 ，列）和一个新的颜色值newColor，让你重新上色这幅图像。
 *
 * 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
 *
 * 最后返回经过上色渲染后的图像。
 *
 * 示例 1:
 *
 * 输入:
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * 输出: [[2,2,2],[2,2,0],[2,0,1]]
 * 解析:
 * 在图像的正中间，(坐标(sr,sc)=(1,1)),
 * 在路径上所有符合条件的像素点的颜色都被更改成2。
 * 注意，右下角的像素没有更改为2，
 * 因为它不是在上下左右四个方向上与初始点相连的像素点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flood-fill
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhouxh-z
 */
public class leetcode_733 {

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int first = image[sr][sc];
        if(first!=newColor){
            image[sr][sc] = newColor;
        }else {
            return image;
        }

        int yLength = image.length;
        int xLength = image[0].length;
        final int i  = sr-1>=0?image[sr-1][sc]:0;
        final int i1 = sc-1>=0?image[sr][sc - 1]:0;
        final int i2 = sr+1<yLength?image[sr+1][sc]:0;
        final int i3 = sc+1<xLength?image[sr][sc+1]:0;

        if(first == i && i!=newColor && sr-1>=0){
            floodFill(image,sr-1,sc,newColor);
        }
        if(first == i1&& i1!=newColor && sc-1>=0){
            floodFill(image,sr,sc-1,newColor);
        }
        if(first == i2&& i2!=newColor && sr+1<yLength){
            floodFill(image,sr+1,sc,newColor);
        }
        if(first == i3&& i3!=newColor && sc+1<xLength){
            floodFill(image,sr,sc+1,newColor);
        }
        return image;
    }



    public int[] x = new int[]{1,0,0,-1};
    public int[] y = new int[]{0,1,-1,0};
    public int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        int first = image[sr][sc];
        if(first == newColor){
            return image;
        }
        image[sr][sc] = newColor;
        int xLength = image.length;
        int yLength = image[0].length;
        for (int i = 0; i < 4; i++) {
            int mx = sr+x[i];
            int my = sc+y[i];
            if(mx>=0 && my>=0 && mx<xLength && my<yLength && image[mx][my]==first && image[mx][my]!=newColor){
                floodFill2(image,mx,my,newColor);
            }
        }
        return image;
    }


    public static void main(String[] args) {
        int[][] ints = new int[][]{{0,0,0},{0,0,0}};
        final leetcode_733 leetcode_733 = new leetcode_733();
        final int[][] ints1 = leetcode_733.floodFill2(ints, 0, 0, 2);
        System.out.println(ints1);
    }
}
