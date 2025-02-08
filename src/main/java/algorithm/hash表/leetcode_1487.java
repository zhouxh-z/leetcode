package algorithm.hash表;

import java.util.*;

/**
 * 给你一个长度为 n 的字符串数组 names 。你将会在文件系统中创建 n 个文件夹：在第 i 分钟，新建名为 names[i] 的文件夹。
 *
 * 由于两个文件 不能 共享相同的文件名，因此如果新建文件夹使用的文件名已经被占用，系统会以 (k) 的形式为新文件夹的文件名添加后缀，其中 k 是能保证文件名唯一的 最小正整数 。
 *
 * 返回长度为 n 的字符串数组，其中 ans[i] 是创建第 i 个文件夹时系统分配给该文件夹的实际名称。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/making-file-names-unique
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhouxianghui6
 * @description
 * @date 2023/3/3
 */
public class leetcode_1487 {
    /**
     * 暴力解 -- 超时问题
     *
     * 原因：j的循环 极限情况下 可能执行很多次
     *
     * @param names
     * @return
     */
    public String[] getFolderNames(String[] names) {
        List<String> rtn = new ArrayList<>();
        rtn.add(names[0]);
        for (int i = 1; i < names.length; i++) {
            if(rtn.contains(names[i])){
                for (int j = 1; j <= i; j++) {
                    String name =  names[i] + "(" + j +")";
                    if(!rtn.contains(name)){
                        rtn.add(name);
                        break;
                    }
                }
            }else {
                rtn.add(names[i]);
            }
        }
        return rtn.toArray(new String[names.length]);
    }

    public String[] getFolderNames1(String[] names) {
        Map<String,Integer> map = new HashMap<>();
        map.put(names[0],1);
        for (int i = 1; i < names.length; i++) {
            if(map.containsKey(names[i])){
                Integer integer = map.get(names[i]);
                String name = names[i] + "(" + integer + ")";
                int nameNum = map.getOrDefault(name,0);
                while (nameNum>0){
                    integer ++;
                    name = names[i] + "(" + integer + ")";
                    nameNum = map.getOrDefault(name,0);
                }
                map.put(name,nameNum + 1);
                map.put(names[i],integer +1 );
                names[i] = name;
            }else {
                map.put(names[i],1);
            }
        }
        return names;

    }

    public static void main(String[] args) {
        String[] strings = {"kaido", "kaido(1)", "kaido", "kaido(1)"};
        leetcode_1487 leetcode_1487 = new leetcode_1487();
        System.out.println(Arrays.toString(leetcode_1487.getFolderNames1(strings)));


    }
}
