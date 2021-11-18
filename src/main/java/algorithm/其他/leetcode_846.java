package algorithm.其他;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.LongAdder;

/**
 *
 * 爱丽丝有一手（hand）由整数数组给定的牌。
 *
 * 现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。
 *
 * 如果她可以完成分组就返回 true，否则返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hand-of-straights
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhouxh-z
 * @date 2021/11/11 15:00
 */
public class leetcode_846 {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int gSize = hand.length / groupSize;
        boolean[] visit = new boolean[hand.length];
        int[] pai = new int[groupSize];
        Arrays.sort(hand);
        int count = 0;
        for (int i = 0; i < gSize; i++) {
            for (int j = 0; j < hand.length ; j++) {
                if(visit[j]){
                    continue;
                }
                if(count == groupSize){
                    count = 0;
                    break;
                }
                if(count == 0 || hand[j] == pai[count-1]+1){
                    pai[count] = hand[j];
                    count++;
                    visit[j] = true;
                }

            }
        }
        boolean flag =true;
        for (int i = 0; i < hand.length; i++) {
           flag = visit[i]&flag;
        }
        return flag;
    }


    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();
        longAdder.add(1);
        final long l = longAdder.longValue();
    }
}
