package coding.小顶堆;


import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Writer;

/**
 * 小顶堆。
 * 数组排列
 * 0,1,2,3,4,5,6,7,8
 * 0 顶点  1 2 是左右子树
 * (0<<1) +1  = 1
 * (0<<1) +2  = 2
 * 0  =  (1 - 1) >>1
 *
 */
public class Code {
    /**
     * 从上到下
     *
     */
    public void siftDownData(int[] arr) {
        int min = arr[arr.length - 1];

        int k = 0;
        while (k < arr.length) {
            // 判断出左右节点哪个是最小的。
            int left = (k >> 1) + 1;
            int right = left + 1;
            int c = arr[left];
            if (arr[right] < c) {
                c = arr[left = right];
            }
            // 判断和当前节点谁小谁大
            if (min < c ) {
                break;
            }
            arr[k] = c;
            k = left;
        }
        arr[k] = min;
    }
    /**
     * 从下向上过滤一下当前数据应该在哪里
     */
    public void siftUpData(int x,int[] arr){
        int length = arr.length - 1;
        while (length > 0) {
            // 找到父节点。
            int root = (length - 1) >> 1;
            // 如果父节点大于它则它应该在当前length节点上保存
            if (arr[root] > x) {
                break;
            }
            // 如果没有当前数字大，那么root 要下沉
            arr[length] = arr[root];
            // 交换索引到上边。
            length = root;
        }
        arr[length] = x;
    }
}
