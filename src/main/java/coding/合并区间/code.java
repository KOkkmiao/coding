package coding.合并区间;


import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: author
 * @Description:
 * @Date: 2024/12/2 9:27 上午
 * @Version: 1.0
 */
public class code {
    /**
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
     *
     * 示例 1：
     *
     * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * 示例 2：
     *
     * 输入：intervals = [[1,4],[4,5]]
     * 输出：[[1,5]]
     * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
     * 1.
     */
    public int[][] merge(int[][] intervals) {
        int[][] res = new int[intervals.length-1][2];
        // 1.按照左节点排序。
        Arrays.stream(intervals).sorted(Comparator.comparingInt(o -> o[0]));
        // 根据顺序遍历
        // 这里的preindex 和巧妙 保证了填充的pre节点永远是上一个 如果从0 开始则要维持量个变量。

        int preIndex = -1;
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            // 和上一个结果比较看看是否有重复的数据
            if (preIndex == -1 || res[preIndex][1] < interval[0]) {
                res[++preIndex] = interval;
            }else{
                // 合并重复的区间数据
                res[preIndex][1] = Math.max(res[preIndex][1],interval[1]);
            }
        }
        return res;
    }
    public int[][] mergeZero(int[][] intervals) {
        int[][] res = new int[intervals.length-1][2];
        // 1.按照左节点排序。
        Arrays.stream(intervals).sorted(Comparator.comparingInt(o -> o[0]));
        // 根据顺序遍历
        // 这里的preindex 和巧妙 保证了填充的pre节点永远是上一个 如果从0 开始则要维持量个变量。
        res[0] = intervals[0];
        int preIndex = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            // 和上一个结果比较看看是否有重复的数据
            if (res[preIndex][1] < interval[0]) {
                res[++preIndex] = interval;
            }else{
                // 合并重复的区间数据
                res[preIndex][1] = Math.max(res[preIndex][1],interval[1]);
            }
        }
        return res;
    }
}
