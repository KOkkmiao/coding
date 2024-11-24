package coding.无重复最长子串;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: author
 * @Description:
 * @Date: 2024/11/24 9:47 下午
 * @Version: 1.0
 */
public class code {
    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
     *
     * 示例 1:
     *
     * 输入: s = "abcdeabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     */
    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> window = new HashMap<>();
        int left = 0;
        int res = 0;
        for (int right = 0; right < s.length(); right++) {
            char v = s.charAt(right);
            window.put(v,window.getOrDefault(v,0)+1);
            // 缩小窗口
            while(window.get(v)>1){
                window.put(v,window.get(v)-1);
                left++;
            }
            res = Math.max(right-left+1,res);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcdabcbb"));
    }
}
