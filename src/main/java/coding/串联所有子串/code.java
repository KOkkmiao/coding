package coding.串联所有子串;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: author
 * @Description:
 * @Date: 2024/11/22 9:30 上午
 * @Version: 1.0
 */
public class code {
    public static void main(String[] args) {
        System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(findSubstringCustomer("barfoothefoobarman", new String[]{"foo", "bar"}));
    }
    public static List<Integer> findSubstringCustomer(String s,String[] words){
        List<Integer> res= new ArrayList<>();
        // words数据字典
        Map<String,Integer> wordsDir = new HashMap<>();
        for (String word : words) {
            Integer orDefault = wordsDir.getOrDefault(word, 0);
            wordsDir.put(word,orDefault+1);
        }
        int wordLen = words[0].length();
        int wordCount = words.length;

        for (int i = 0; i < s.length() - wordLen*wordCount; i++) {
            Map<String,Integer> window = new HashMap<>();
            // 从 节点 i 切割 wordCount 个 字符串
            int num = 0;
            while(num < wordCount) {
                String w = s.substring(i + (num * wordLen), i+(num * wordLen) + wordLen);
                // 窗口添加
                if (wordsDir.containsKey(w)) {
                    Integer orDefault = window.getOrDefault(w, 0);
                    window.put(w,orDefault+1);
                }else {
                    break;
                }
                num++;
                // 窗口收缩
                if (num == wordCount) {
                    for (String s1 : wordsDir.keySet()) {
                        if (window.getOrDefault(s1,0) != wordsDir.get(s1)) {
                            break;
                        }
                    }
                 res.add(i);
                }

            }
        }
        return res;
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int wordNum = words.length;
        if (wordNum == 0) {
            return res;
        }
        int wordLen = words[0].length();
        //HashMap1 存所有单词
        HashMap<String, Integer> allWords = new HashMap<String, Integer>();
        for (String w : words) {
            int value = allWords.getOrDefault(w, 0);
            allWords.put(w, value + 1);
        }
        //遍历所有子串
        for (int i = 0; i < s.length() - wordNum * wordLen + 1; i++) {
            //HashMap2 存当前扫描的字符串含有的单词
            HashMap<String, Integer> hasWords = new HashMap<String, Integer>();
            int num = 0;
            //判断该子串是否符合
            while (num < wordNum) {
                String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
                //判断该单词在 HashMap1 中
                if (allWords.containsKey(word)) {
                    int value = hasWords.getOrDefault(word, 0);
                    hasWords.put(word, value + 1);
                    //判断当前单词的 value 和 HashMap1 中该单词的 value
                    if (hasWords.get(word) > allWords.get(word)) {
                        break;
                    }
                } else {
                    break;
                }
                num++;
            }
            //判断是不是所有的单词都符合条件
            if (num == wordNum) {
                res.add(i);
            }
        }
        return res;
    }

}
