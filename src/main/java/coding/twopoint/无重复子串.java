package coding.twopoint;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: author
 * @Description:
 * @Date: 2024/11/7 9:37 上午
 * @Version: 1.0
 */
public class 无重复子串 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < s.length()) {
            window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 1));
            right++;
            while (window.get(s.charAt(right)) > 1) {
                window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
