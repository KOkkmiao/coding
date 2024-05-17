package coding.twopoint;


import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.SimpleFormatter;

public class 丰富的字符串 {

    public static void main(String[] args) {
        SimpleDateFormat yyyy = new SimpleDateFormat("yyyy");
        SimpleDateFormat YYYY = new SimpleDateFormat("YYYY");
        Date date = new Date();
        System.out.println(yyyy.format(date));
        System.out.println(YYYY.format(date));
    }

    /**
     *  heeelllllooo
     *
     *  字符串的某个字符扩展的三个以上。
     *  能够匹配上的字符 hello
     *  add change 123
     *  add change 321
     *
     *  change rebase log
     *
     */
    public static int expressiveWords(String s, String[] words) {
        int result = 0;
        for (String word : words) {
            int i = 0,j= 0; // 初始化双指针。
            while(i<word.length()&&j<s.length()){
                char wordsChar = word.charAt(i);
                char sChar = s.charAt(j);
                // 先判断 wordChar 是否是重叠的字符串 重叠了 找出重叠个数。 给下边的schar 做减法 判断是否是大于3个
                for( ;i + 1<word.length()-1 &&word.charAt(i+1) == wordsChar;i++) {
                }

                //判断两个字符是否相同。 相同则 j 指针继续走
                // 不相同则判断 char 是否和 i++ 的值相同 相同则继续 不同则word 不匹配
                // 这里判断重复的字段个数是否是三个以上。
                while (wordsChar ==sChar && j<s.length()-1&& s.charAt(j+1)==wordsChar ) {
                    j++;
                    sChar = s.charAt(j);
                }
                //判断这里重复的个数是否和预期一样。  i==j || j-i >=2
                if (i==j || j-i >=2){
                    i++;
                    j++;
                }else{
                    // 是不合法的数据
                    break;
                }

                if (i==word.length() && j==s.length()){
                    // 获得一个结果
                    result++;

                }
            }
        }
        return result;
    }
    /**
     * 最长无重复子串
     * abcaddd
     *  abc  最长： 3
     *  abca 需要从a1 索引换到 a2 索引下。然后计算一次最长子串大小
     *  因为这里的结果是要数字 不是字符串 结果。
     *  额外：输出字符串内容。
     */
    @Test
    public void testDupLongSubString(){
        String s = "abcajj";
        int i = 0;  int res = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (window.containsKey(c)) {
                 i = j;
            }
            window.put(c,j);
            res = Math.max(res, j - i+1);
        }
    }
    @Test
    public void testTTT2(){
        System.out.println(lengthOfLongestSubstring("abcaj"));
    }
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0, len = s.length();
        for(int j = 0; j < len; j++) {
            if (dic.containsKey(s.charAt(j)))
                i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
            dic.put(s.charAt(j), j); // 哈希表记录
            res = Math.max(res, j - i); // 更新结果
        }
        return res;
    }
    @Test
    public void testArrays(){
        int[][]  arrays= new int[][]{};
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                int a = arrays[i][j];
                int b = arrays[i + 1][j + 1];
                int c = arrays[i + 2][j + 2];
            }
        }

            
            


    }
}
