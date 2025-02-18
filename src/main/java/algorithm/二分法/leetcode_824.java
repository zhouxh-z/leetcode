package algorithm.二分法;

import java.util.Arrays;
import java.util.Locale;

/**
 * 
 * 给你一个由若干单词组成的句子sentence ，单词间由空格分隔。每个单词仅由大写和小写英文字母组成。
 *
 * 请你将句子转换为 “山羊拉丁文（Goat Latin）”（一种类似于 猪拉丁文- Pig Latin 的虚构语言）。山羊拉丁文的规则如下：
 *
 * 如果单词以元音开头（'a', 'e', 'i', 'o', 'u'），在单词后添加"ma"。
 * 例如，单词 "apple" 变为 "applema" 。
 * 如果单词以辅音字母开头（即，非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
 * 例如，单词 "goat" 变为 "oatgma" 。
 * 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从 1 开始。
 * 例如，在第一个单词后添加 "a" ，在第二个单词后添加 "aa" ，以此类推。
 * 返回将 sentence 转换为山羊拉丁文后的句子。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/goat-latin
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @ClassName algorithm.二分法
 * @Description:
 * @Author zhouxianghui6
 * @Date 2022/4/21 10:09
 * @since
 **/
public class leetcode_824 {

    public String toGoatLatin(String sentence) {
        String[] s = sentence.split(" ");
        String[] rtn = new String[s.length];
        int start = 0;
        int end = s.length - 1;
        while (start<=end){
            rtn[start] = toGet(s[start], start);
            rtn[end] = toGet(s[end], end);
            start++;
            end--;
        }
        StringBuilder sb = new StringBuilder();
        Arrays.asList(rtn).forEach(o->sb.append(o).append(" "));
        return sb.toString().trim();
    }



    public String toGet(String startStr,int index){
        StringBuilder rtn = new StringBuilder();
        String s = startStr.toLowerCase();
        if(s.startsWith("a")|| s.startsWith("e")
                || s.startsWith("i")|| s.startsWith("o")
                || s.startsWith("u")){
            rtn.append(startStr).append("ma");
        }else {
            rtn.append(startStr.substring(1)).append(startStr.charAt(0)).append("ma");
        }
        for (int i = 0; i <= index; i++) {
            rtn.append("a");
        }
        return rtn.toString();
    }

}


