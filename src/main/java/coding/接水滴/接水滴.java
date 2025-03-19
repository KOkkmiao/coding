package coding.接水滴;

/**
 * @Author: author
 * @Description:
 * @Date: 2024/11/12 9:57 上午
 * @Version: 1.0
 */
public class 接水滴 {
    // 接水的最大区域。底乘高。
    public int maxArea(int[] height) {
        int left =0;
        int right =height.length-1;
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            int heightv = Math.max(height[left],height[right]);
            res = Math.max((right-left)*heightv,res);
            if (height[left]<height[right]){
                left++;
            }else {
                right++;
            }
        }
        return res;
    }
    // 接水滴判断最多能解多少水。
    /**
     * 依据左右节点值谁小和当前节点的差值就是能存储的水位。
     * @param height
     * @return
     */
    public int maxAreaCount(int[] height) {
        int left = height[0];
        int right = height[height.length-1];
        int l_max = 0,r_max=0,res = 0;
        while (left < right) {
            l_max = Math.max(l_max, height[left]);
            r_max = Math.max(r_max, height[right]);
            if (l_max < r_max) {
                res += l_max-height[left];
                left++;
            }else{
                res += r_max-height[right];
                right--;
            }
        }
        return res;
    }
}
