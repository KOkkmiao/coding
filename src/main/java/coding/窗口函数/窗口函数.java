package coding.窗口函数;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: author
 * @Description:
 * @Date: 2024/11/8 9:16 上午
 * @Version: 1.0
 */
public class 窗口函数 {
    public static String templete(String s) {
        int left = 0;
        int right = 0;
        Map<Character, Integer> windows = new HashMap<>();
        // 窗口是要由情况而定。
        String res = "";
        while (right < s.length()) {
            char c = s.charAt(right);
            // 选择元素right 向右
            right++;
            Integer orDefault = windows.get(c);
            windows.put(c, orDefault == null ? 1 : orDefault + 1);
            while (windows.get(c) > 1) {// 这里就是判定窗口内的数据是否符合条件。如果不符合则需要缩小窗口
                Integer count = windows.get(c);
                windows.put(c, --count);
                left++; // 缩小窗口
            }
            if (res.length() < (right - left)) {
                res = s.substring(left, right);
            }
            // 这里就是需要判定结果。因为窗口内的数据已经满足条件了。
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(templete("abcdan"));
    }
}
