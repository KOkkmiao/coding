package coding.count;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author xpmiao
 * @date 2024/5/17
 */
public class 双指针解决数组问题 {
    /**
     * 根据双指针删除列表里的重复数据
     * 前提： 数组按照升序排序好的
     * e.g [1,1,2,2,2,3,3,3,4]
     */
    public static int[] removeDupData(int[] data){
        if (data.length == 1 || data.length == 0) {
            return data;
        }
        int last = 0;
        int fast = 0;
        while (fast < data.length) {
            if (data[last] != data[fast]) {
                last++;
                data[last] = data[fast];
            }
            fast++;
        }
        return data;
    }
    /**
     * 给你输入一个数组 nums，请你原地修改，将数组中的所有值为 0 的元素移到数组末尾，函数签名如
     *  e.g nums = [0,1,4,0,2]   [1,4,2,0,0]
     */
    public static int[] moveZeros(int[] data,int val){
        if (data.length == 1 || data.length == 0) {
            return data;
        }
        int last = 0, fast = 0;
        while(fast< data.length){
            if (data[fast] !=val) {
                data[last] = data[fast];
                data[fast] = val;
                last++;
            }
            fast++;
        }
        return data;
    }

    /**
     * 双指针解决最大回文问题
     * aba  aba
     * cbbd  bb
     * @return
     */
    @Test
    public void longestPalindrome() {
        String max ="";
        String s = "cqabazc";
        for (int i = 0; i < s.length(); i++) {
            String 偶数str = 获取回文(i, i, s);
            String 奇数str = 获取回文(i, i+1, s);
            String s1 = 偶数str.length() > 奇数str.length() ? 偶数str : 奇数str;
            max = s1.length() > max.length() ? s1 : max;
        }
        System.out.println(max);
    }
    public String 获取回文(int left,int right,String s){
        String res = "";
        while (left >= 0 && right < s.length()) {
            char c = s.charAt(left);
            char c1 = s.charAt(right);
            if (c == c1) {
                res = s.substring(left,right+1);
            }else {
                return res;
            }
            left--;
            right++;
        }
        return res;
    }
    @Test
    public void test(){
        int[] ints = removeDupData(new int[] {1, 1, 2, 2, 2, 3, 3, 3, 4});
        Arrays.stream(ints).forEach(System.out::print);
        System.out.println();
        int[] ints1 = moveZeros(new int[] {0, 1, 4, 0, 2}, 0);
        Arrays.stream(ints1).forEach(System.out::print);
    }

}
