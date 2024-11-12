package coding.接水滴;

/**
 * @Author: author
 * @Description:
 * @Date: 2024/11/12 9:57 上午
 * @Version: 1.0
 */
public class 接水滴 {
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
    }
}
