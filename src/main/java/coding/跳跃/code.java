package coding.跳跃;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 * @Author: author
 * @Description:
 * @Date: 2024/11/29 10:07 上午
 * @Version: 1.0
 */
public class code {
    public static String a = "1";
    public static String a1 = "1";
    public static String a2 = "1";
    public static String a3 = "1";
    private static boolean res = false;

    public static boolean canJump(int[] nums) {
        xx(nums[0], nums, 0);
        return res;
    }

    public static void xx(int step, int[] nums, int index) {
        if (index >= nums.length) {
            return;
        }
        if (index == nums.length - 1) {
            res = true;
            return;
        }
        // 跳跃的值作为循环
        for (int i = 1; i <= step; i++) {
            int next = nums[i + index];
            xx(next, nums, i + index);
        }
    }

    public static boolean v2(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && nums[j] >= i - j) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length - 1];
    }


    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
        var list = new ArrayList<String>();   // 推断为 ArrayList<String>
        var num  = 123;                       // int
        var pi   = 3.14;                      // double
        var flag = true;
        System.out.println(Integer.toBinaryString(0xF));
        System.out.println(0xA);

        int a = 0x1A;
        int aa = a | 1;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(aa));
        System.out.println(Integer.toBinaryString(aa & ~0xF));
        System.out.println(0xF);

    }
}
