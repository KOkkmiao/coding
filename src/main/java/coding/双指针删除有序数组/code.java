package coding.双指针删除有序数组;

import java.util.Arrays;

/**
 * @Author: author
 * @Description:
 * @Date: 2024/11/21 9:30 上午
 * @Version: 1.0
 */
public class code {
    /**
     * 双指针删除有序数组。
     * 输入：nums = [1,1,2] 输出：2, nums = [1,2,_]
     * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[left] != nums[right]) {
                // 置换数据 左节点向前
                left++;
                nums[left] = nums[right];
            }
        }
        Arrays.stream(nums).forEach(System.out::print);
        return left + 1;
    }

    /**
     * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
     * 输出：5, nums = [0,1,4,0,3,_,_,_]
     * 解释：你的函数应该返回 k = 5，并且 nums 中的前五个元素为 0,0,1,3,4。
     * @param args
     */
    public static int removeDirectNumber(int[] nums,int number) {
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != number) {
                // 置换数据 左节点向前
                nums[left] = nums[right];
                left++;
            }
        }
        Arrays.stream(nums).forEach(System.out::print);
        return left + 1;
    }
    public static void main(String[] args) {
        removeDuplicates(new int[]{1,1,2,2,2,3,5,5});
        System.out.println();
        removeDirectNumber(new int[]{0,1,2,2,3,0,4,2},2);
    }
}
