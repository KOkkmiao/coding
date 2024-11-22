package coding.生成括号;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: author
 * @Description:
 * @Date: 2024/11/19 9:15 上午
 * @Version: 1.0
 */
public class code {
    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     * 根据回溯法来处理
     */
    public static void code(int n) {
        dfs(n, "", 0, 0);
    }

    private static List<String> results = new LinkedList<>();

    private static void dfs(int n, String res, int left, int right) {
        // 左括号要小于n 右括号也要小于n 拼接过程中右括号不能先于左括号拼接，所以right需要小于left
        if (left >n || right>n || right>left) {
            return;
        }
        if (n * 2 == res.length()) {
            results.add(res);
            return;
        }

        dfs(n, res + "(", left + 1, right);
        dfs(n, res + ")", left, right + 1);

    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        back(n, result, 0, 0, "");
        return result;
    }

    private static void back(int n, List<String> result, int left, int right, String str) {
        if (right > left) {
            return;
        }
        if (left == n && right == n) {
            result.add(str);
            return;
        }
        if (left < n) {
            back(n, result, left + 1, right, str + "(");
        }
        if (left > right) {
            back(n, result, left, right + 1, str + ")");
        }
    }

    public static void main(String[] args) {
        code(3);
        System.out.println(results);
    }

}
