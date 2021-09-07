package algorithm.递归_回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * @author 17826
 */
public class leetcode_784 {
    List<StringBuilder> bns = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        // 方法一
        char[] chars = s.toCharArray();
         letterCasePermutation2(chars,0);
         return ans;
    }

    /**
     * 方法一
     * @param chars
     * @param index
     */
    public void letterCasePermutation(char[] chars,int index) {
        if(index >= chars.length){
            return;
        }
        // 变
        char aChar = chars[index];
        if(aChar>=0&&aChar<=9){
            letterCasePermutation(chars,index+1);
        }else {
            if (aChar>='a' && aChar<='z'){
                chars[index] -= 32;
                if(!ans.contains(new String(chars))){
                    ans.add(new String(chars));
                }
                letterCasePermutation(chars,index+1);
                chars[index] += 32;
            }else if(aChar>='A' && aChar<='Z'){
                chars[index] += 32;
                if(!ans.contains(new String(chars))){
                    ans.add(new String(chars));
                }
                letterCasePermutation(chars,index+1);
                chars[index] -= 32;
            }

            // 不变
            final String s = new String(chars);
            if(!ans.contains(s)){
                ans.add(s);
            }
            letterCasePermutation(chars,index+1);
        }

    }

    /**
     *  youhua
     * @param chars
     * @param index
     */
    public void letterCasePermutation2(char[] chars,int index) {
        if(!ans.contains(new String(chars))){
            ans.add(new String(chars));
        }

        if(index>=chars.length){
            return;
        }
        final char aChar = chars[index];
        if (aChar>='a' && aChar<='z'){
            chars[index] -= 32;
            letterCasePermutation2(chars,index+1);
            chars[index] += 32;
            letterCasePermutation2(chars,index+1);
        }else if(aChar>='A' && aChar<='Z'){
            chars[index] += 32;
            letterCasePermutation2(chars,index+1);
            chars[index] -= 32;
            letterCasePermutation2(chars,index+1);
        }else {
            letterCasePermutation2(chars,index+1);
        }
    }

    public static void main(String[] args) {
        leetcode_784 l = new leetcode_784();
        final List<String> a1b2 = l.letterCasePermutation("abcd");
        System.out.println();
    }
}
