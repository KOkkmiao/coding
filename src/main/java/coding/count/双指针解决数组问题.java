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
    @Test
    public void test(){
        int[] ints = removeDupData(new int[] {1, 1, 2, 2, 2, 3, 3, 3, 4});
        Arrays.stream(ints).forEach(System.out::print);
        System.out.println();
        int[] ints1 = moveZeros(new int[] {0, 1, 4, 0, 2}, 0);
        Arrays.stream(ints1).forEach(System.out::print);
    }

}
