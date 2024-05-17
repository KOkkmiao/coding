package coding.dynamic;

import java.util.Arrays;
import java.util.Optional;

/**
 * 给定数组 nums 和一个整数 k 。我们将给定的数组 nums 分成 最多 k 个相邻的非空子数组 。 分数 由每个子数组内的平均值的总和构成。
 * <p>
 * 注意我们必须使用 nums 数组中的每一个数进行分组，并且分数不一定需要是整数。
 * <p>
 * 返回我们所能得到的最大 分数 是多少。答案误差在 10-6 内被视为是正确的。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [9,1,2,3,9], k = 3
 * 输出: 20.00000
 * 解释:
 * nums 的最优分组是[9], [1, 2, 3], [9]. 得到的分数是 9 + (1 + 2 + 3) / 3 + 9 = 20.
 * 我们也可以把 nums 分成[9, 1], [2], [3, 9].
 * 这样的分组得到的分数为 5 + 2 + 6 = 13, 但不是最大值.
 * 示例 2:
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 4
 * 输出: 20.50000
 */
public class 平均数分组求最大 {
    /**
     * 基于 dp 二维数组来记录分组的变化  【9,1,2,3,9】
     * 前缀数组
     *  prefix = 【0,9,10,12,15,24】
     *    0  1  2  3
     * 0  0  0  0  0
     * 1  0  9
     * 2  0  5
     * 3  0  4
     * 4  0  3.75
     * 5  0  4.8
     * @param nums
     * @param k
     * @return
     */
    public double largestSumOfAveragesSolution(int[] nums, int k) {
        int[] prefix = new int[nums.length+1];
        prefix[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix[i+1] = nums[i] +prefix[i];
        }
        int[][] dp = new int[nums.length+1][k+1];
        for (int i = 1; i < dp.length; i++) {
            dp[i][1] = prefix[i]/i;
        }
        for (int j = 2; j < k; j++) { // 至少分割的个数是两个
            for (int i = j; i<nums.length ; i++) { //至少数组的个数大于等于分割的个数
                // x 的意思是 在分割数为2 的情况下 可以是 【9】【1，2】
                // 或者 【9,1】【2】
                for (int x = j-1; x < i ; x++) {
                    dp[i][j] = Math.max(dp[i][j],dp[x][j - 1] + (prefix[i] - prefix[x]) / (i - x));
                }
            }
        }
        return dp[nums.length][k];
    }
    public static void main(String[] args) {

    }
}
