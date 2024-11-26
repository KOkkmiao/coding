package coding.最大子数组合;

/**
 * @Author: author
 * @Description:
 * @Date: 2024/11/26 9:23 上午
 * @Version: 1.0
 */
public class code {
    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 子数组 是数组中的一个连续部分。
     * [-2,1,-3]
     *
     */
    public int maxNumber(int[] nums){
        int pre=0;
        int res=0;
        for (int num : nums) {
            pre = Math.max(pre+num,num);
            res = Math.max(pre,res);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
