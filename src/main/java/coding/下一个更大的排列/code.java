package coding.下一个更大的排列;

import java.util.Arrays;

/**
 * @Author: author
 * @Description:
 * @Date: 2024/11/24 8:58 下午
 * @Version: 1.0
 */
public class code {

        public void nextPermutation(int[] nums) {
            int i = nums.length - 2;
            // 从后向前找到前者比后者小的数字。
            while(i >= 0 && nums[i] >= nums[i+1]){
                i--;
            }
            if(i >= 0){
                // 找到后 再将后续数据从i 到nums.length 找打一个比nums[i]大的数 切换
                int j = nums.length - 1;
                while(j>= 0 && nums[j] <= nums[i]){
                    j--;
                }
                swap(nums,i,j);
            }
            // 最后吧i 之后的数据排序。
            reverse(nums,i+1);
        }

        public void swap(int[] nums,int i,int j){
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }

        //翻转从start开始的数组序列，原来肯定是降序（从大到小），转换为升序（从小到大）
        public void reverse(int[] nums,int start){
            int left = start;
            int right = nums.length-1;
            while(left < right){
                swap(nums,left,right);
                left++;
                right--;
            }
        }

}
