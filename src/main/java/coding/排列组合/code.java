package coding.排列组合;

import java.util.*;

public class code {

    /**
     * 排列组合
     *
     * [] [1],[1,2],[1,2,3][1,3][2,3]
     */
    // public static void main(String[] args) {
    //     // show(new int[] {1, 2, 3}, 0, new LinkedList<>());
    //     System.out.println(result);
    // }

    public static List<List<Integer>> result = new ArrayList<>();
    public static void show(int[] nums, int start, LinkedList<Integer> res, List<List<Integer>> result) {
        if (!res.isEmpty()) {
            result.add(new ArrayList<>(res));
        }
        for (int i = start; i < nums.length; i++) {
            res.add(nums[i]);
            show(nums, i + 1, res, result);
            res.removeLast();
        }
    }
    public static List<String> expandStars(String input) {
        Set<String> results = new HashSet<>();
        dfs(input, 0, new StringBuilder(), results);
        return new ArrayList<>(results);
    }

    private static void dfs(String input, int index, StringBuilder current, Set<String> results) {
        if (index == input.length()) {
            results.add(current.toString());
            return;
        }

        char ch = input.charAt(index);
        if (ch == '*') {
            // 选项1：替换为1个'X'
            current.append('X');
            dfs(input, index + 1, current, results);
            current.deleteCharAt(current.length() - 1); // 回溯

            // 选项2：替换为2个'X'
            current.append("XX");
            dfs(input, index + 1, current, results);
            current.delete(current.length() - 2, current.length()); // 回溯
        } else {
            // 非星号字符，直接追加
            current.append(ch);
            dfs(input, index + 1, current, results);
            current.deleteCharAt(current.length() - 1); // 回溯
        }
    }

    public static void main(String[] args) {
        String input = "*1*11";
        List<String> combinations = expandStars(input);
        for (String comb : combinations) {
            System.out.println(comb);
        }
    }
}
