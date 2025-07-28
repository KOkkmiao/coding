package coding.判断括号;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author: author
 * @Description:
 * @Date: 2024/11/18 10:02 上午
 * @Version: 1.0
 */
public class code {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     */
    public static boolean code(String s) {
        LinkedList<Character> dp = new LinkedList<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put('}', '{');
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                Character character = dp.pollLast();
                if (character != map.get(s.charAt(i))) {
                    return false;
                }
            } else {
                dp.add(s.charAt(i));
            }
        }
        return true;
    }
    public static boolean code2(String s) {
        LinkedList<Character> queue = new LinkedList<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('}','{');
        map.put(']','[');
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                // 存在右括号了。 则需要弹出
                Character character = queue.pollLast();
                if (character != map.get(s.charAt(i))) {
                    return false;
                }
            }else{
                // 所有做括号都压栈了。
                queue.add(s.charAt(i));
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(-10>>>10);
    }
}
