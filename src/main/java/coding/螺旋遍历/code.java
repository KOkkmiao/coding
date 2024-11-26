package coding.螺旋遍历;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: author
 * @Description:
 * @Date: 2024/11/26 9:31 上午
 * @Version: 1.0
 */
public class code {
    /**
     * 定义好上下左右边界即可
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;
        int upbound = 0;
        int bottonbound = x -1;
        int leftbound = 0;
        int rightbound = y-1;
        List<Integer> res = new LinkedList<>();
        while (res.size() < x * y) {
            if (upbound <= bottonbound) {
                // 从左向右
                for (int i = leftbound; i < rightbound; i++) {
                    res.add(matrix[upbound][i]);
                }
                upbound++;
            }
            if (leftbound <= rightbound) {
                //从上到下遍历
                for (int i = upbound; i < bottonbound; i++) {
                    res.add(matrix[i][rightbound]);
                }
                rightbound--;
            }
            if (upbound <= bottonbound) {
                // 从右到左
                for (int i = rightbound; i >= leftbound; i--) {
                    res.add(matrix[bottonbound][i]);
                }
                bottonbound--;
            }
            if (leftbound <= rightbound) {
                // 从下到上
                for (int i = bottonbound; i >= upbound; i--) {
                    res.add(matrix[i][leftbound]);
                }
                leftbound--;
            }
        }
        return res;
    }
}
