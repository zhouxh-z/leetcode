package algorithm.广度_深度优先搜索;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
 *
 * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v
 * 可以打开编号为 v 的房间。
 *
 * 最初，除 0 号房间外的其余所有房间都被锁住。
 *
 * 你可以自由地在房间之间来回走动。
 *
 * 如果能进入每个房间返回 true，否则返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/keys-and-rooms
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhouxh-z
 * @date 2021/9/29 18:06
 */
public class leetcode_841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        List<Integer> keys = rooms.get(0);
        boolean[] flag = new boolean[rooms.size()];
        Queue<Integer> keyQueue = new LinkedList<>(keys);

        while (!keyQueue.isEmpty()){
            Integer k = keyQueue.poll();
            if(!flag[k]){
                flag[k] = true;
                List<Integer> integers = rooms.get(k);
                keyQueue.addAll(integers);
            }
        }
        boolean rtn = true;

        for (int i = 1; i < flag.length ; i++) {
            rtn = rtn && flag[i];
        }
        return rtn;
    }

    public static void main(String[] args) {
        leetcode_841 l = new leetcode_841();
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> room0 = new ArrayList<>();
        room0.add(1);
        List<Integer> room1 = new ArrayList<>();
        room1.add(2);
        List<Integer> room2 = new ArrayList<>();
        room2.add(3);
        List<Integer> room3 = new ArrayList<>();
        rooms.add(room0);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        l.canVisitAllRooms(rooms);
    }
}
