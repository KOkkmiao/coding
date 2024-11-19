package coding.电话号码组合;


import java.util.*;

/**
 * @Author: author
 * @Description:
 * @Date: 2024/11/18 9:17 上午
 * @Version: 1.0
 */
public class code {
    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     *
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     */
    public static void code(String s){
        List<String> result = new ArrayList<>();
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        track(result,new StringBuilder(),s,0,phoneMap);
        System.out.println(result);

    }

    public static void main(String[] args) {
        code("23");
    }
    public static void track(List<String> result,StringBuilder tmp,String s,int index,Map<Character, String> phoneMap){
        if (tmp.length() == s.length()){
            result.add(tmp.toString());
            return;
        }
        char key = s.charAt(index);
        String source = phoneMap.get(key);
        for (int i = 0; i < source.length(); i++) {
            tmp.append(source.charAt(i));
            track(result, tmp, s, index + 1, phoneMap);
            tmp.delete(tmp.length()-1,tmp.length());
        }
    }
}
