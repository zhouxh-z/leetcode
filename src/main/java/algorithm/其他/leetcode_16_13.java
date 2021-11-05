package algorithm.其他;


/**
 * 
 * @author zhouxh-z
 * @date 2021/10/26 18:35
 */
public class leetcode_16_13 {
    public double[] cutSquares(int[] square1, int[] square2) {
        // 找到两个正方形的中心，然后连线的交点就是答案
        double f = square1[0];
        double s = square1[1];
        double t = square1[2];
        // 中心坐标
        double x = f + t / 2;
        double y = s + t / 2;

        double f2 = square2[0];
        double s2 = square2[1];
        double t2 = square2[2];
        // 中心坐标
        double x2 = f2 + t2 / 2;
        double y2 = s2 + t2 / 2;


        if(x == x2){
            // 和 y 轴平行
            return new double[]{x,Math.min(s,s2),x,Math.max(s+t,s2+t2)};
        }

        if(y == y2){
            return new double[]{Math.min(f,f2),y,Math.max(f+t,f2+t2),y};
        }
        // 斜率
        double k = (y2 - y) / (x2 - x);
        // kx + v = y 这就是方程
        double v = y - k * x;
        // 那么可以得出两个正方形 与方程线 相交的 8/4 个点（如果是8个点 其中 4个点不在正方形上）
        // 交点是否在y轴平行的边上
        boolean flag = false;
        // 坐标 (f,y1)
        double y1 = k * f + v;
        // 判断该点在不在正方形上，
        if(y1>=s && y1<=s+t){
            flag = true;
        }
        // 交点在y轴
        if(flag){
            final double minx = Math.min(f, f2);
            final double miny = k * minx + v;
            final double maxx = Math.max(f+t, f2+t2);
            final double maxy = k * maxx + v;
            if(minx>maxx){
                return new double[]{maxx,maxy,minx,miny};
            }
            return new double[]{minx,miny,maxx,maxy};
        }else {
            // 交点在x轴 平行边上,找最大最小的y
            double miny = Math.min(s, s2);
            double minx = (miny - v) / k;
            double maxy = Math.max(s + t, s2 + t2);
            double maxx = (maxy - v ) / k;
            if(minx>maxx){
                return new double[]{maxx,maxy,minx,miny};
            }
            return new double[]{minx,miny,maxx,maxy};
        }
    }

    public static void main(String[] args) {
        leetcode_16_13 l = new leetcode_16_13();
        l.cutSquares(new int[]{249,-199,5},new int[]{-1,136,76});
    }
}
