package coding.count;



import coding.entity.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 两数之和链表 {
    /**
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return recursion(l1, l2, 0);
    }

    public ListNode recursion(ListNode l1, ListNode l2, int add) {
        if (l1 == null && l2 == null) {
            return add > 0 ? new ListNode(add) : null;
        }

        ListNode root = new ListNode();
        int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + add;

        root.val = sum % 10;
        root.next = recursion(l1 == null ? null : l1.next, l2 == null ? null : l2.next, sum / 10);
        return root;
    }
    public int[] twoSum(int[] nums, int target) {
        // 两数之和。 使用hashmap 处理最容易。
        Map<Integer,Integer> values = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int expect = target - num;
            if (values.get(expect) !=null) {
                return new int[]{i,values.get(expect)};
            }
            values.put(num,i);
        }
        return new int[]{};
    }
    /**
     * 两数之和使用双指针方式来处理，先排序 后两段向中间走。
     * @param nums
     * @param target
     * @return
     */
    public List<int[]> twoSumPoint(int[] nums, int target){
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
        List<int[]> values = new ArrayList<>();
        while(left<=right){
            int numleft = nums[left];
            int numright = nums[right];
            int sum =  numleft + numright;
            if (sum == target) {
                values.add(new int[]{left,right});
                while(left<=right && numleft == nums[left]) left++;
                while(left<=right && numright == nums[right]) right++;
            }else if (sum<target){
                // 如果出现重复的数据需要走到最中间
                while(left<=right && numleft == nums[left]) left++;
            }else {
                while(left<=right && numright == nums[right]) right++;
            }
        }
        return values;
    }
}
