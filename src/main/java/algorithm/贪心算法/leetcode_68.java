package algorithm.贪心算法;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouxh-z
 * @date 2021/9/9 14:42
 */
public class leetcode_68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int sum = 0;
        int last = 0;
        List<int[]> sumList = new ArrayList<>();
        List<String> rtnStr = new ArrayList<>();
        for (int i = 0 ;i<words.length;i++) {
            if(sum+words[i].length()<=maxWidth){
                sum += words[i].length()+1;
                last++;
            }else {
                i--;
                sumList.add(new int[]{sum-1,last,i});
                sum = 0;
                last = 0;
            }
            if(i==words.length-1){
                sumList.add(new int[]{sum-1,last,i});
            }
        }
        // s[0] 对应行数 单词数目多少，s[1]几个单词;
        for (int i = 0; i < sumList.size(); i++) {
            int [] s = sumList.get(i);
            //x 表示 每个空格多少个 y表示余下多少个\
            int x = 0, y =maxWidth - s[0];
            if(s[1]-1 != 0){
                x = (maxWidth - s[0]+s[1]-1) / (s[1]-1);
                y = (maxWidth - s[0]+s[1]-1) % (s[1]-1);
            }
            StringBuilder stringBuilder = new StringBuilder();
            if(i<sumList.size()-1&&s[1]>1){
                for(int j=s[2]-s[1]+1 ; j<=s[2];j++){
                    stringBuilder.append(words[j]);
                    if(j!=s[2]){
                        for (int k = 0; k < x; k++) {
                            stringBuilder.append(" ");
                        }
                    }
                    if(j<=s[2]-s[1]+1+y){
                        stringBuilder.append(" ");
                    }
                }
            }else {
                for(int j=s[2]-s[1]+1 ; j<=s[2];j++){
                    stringBuilder.append(words[j]);
                    if(j!=s[2]){
                        stringBuilder.append(" ");
                    }
                    if(j==s[2]){
                        int i1 = (x * (s[1] - 1) + y) - s[1]+1;
                        for (int k = 0; k < i1; k++) {
                            stringBuilder.append(" ");
                        }
                    }
                }
            }

            rtnStr.add(stringBuilder.toString());
        }
        return rtnStr;
    }


    public static void main(String[] args) {
        leetcode_68 l = new leetcode_68();
        l.fullJustify(new String[]{"Science","is","what","we","understand","well",
                "enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"},
                20);
    }
}
