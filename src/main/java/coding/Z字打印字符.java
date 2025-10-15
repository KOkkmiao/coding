package coding;

import coding.跳跃.code;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author: author
 * @Description:
 * @Date: 2024/11/11 9:52 上午
 * @Version: 1.0
 */
public class Z字打印字符 {
    /**
     * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
     *
     * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
     *
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        List<StringBuilder> value = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            value.add(new StringBuilder());
        }
        int j = 0;
        int flag=-1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            value.get(j).append(c);
            // 判断是否转向
            if (numRows-1 == j|| j == 0) {
                flag = -flag;
            }
            j += flag;
        }
        StringBuilder builder = new StringBuilder();
        for (StringBuilder row :value){
            builder.append(row.toString());
        }
        return builder.toString();
    }
    public static void convert2(String s, int numRows) {
        List<StringBuilder> value = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            value.add(new StringBuilder());
        }
        // 添加好层数的几个。  字符串肯定是按照顺序便利的。 只是放入value的顺序不一样。
        int j = 0;
        int flag=-1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            value.get(j).append(c);
            // 判断应该在哪一个j 的时候转换方向。 1 j == 0 的时候需要转化 因为要向下了。 当到达最下边界的时候也要转变
            if (j == numRows - 1 || j == 0) {
                flag = -flag;
            }
            j +=flag;
        }
        for (StringBuilder stringBuilder : value) {
            System.out.println(stringBuilder);
        }
    }
    public static void convert3(String s, int numRows) {
        int count = s.length() / numRows ;
        int gapCount = numRows - 2;
        int total = (count - 1) * gapCount + count;
        char[][] values = new char[numRows][total];
        // 添加好层数的几个。  字符串肯定是按照顺序便利的。 只是放入value的顺序不一样。
        int j = 0;
        int k = 0;
        int flag=-1;
        boolean flagRight = true;
        int rightCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            values[j][k] = c;
            // 判断应该在哪一个j 的时候转换方向。 1 j == 0 的时候需要转化 因为要向下了。 当到达最下边界的时候也要转变
            if (j == numRows - 1 || j == 0) {
                flag = -flag;
                // 前者翻转当前不翻转。
                flagRight = !flagRight;

                if (flagRight) {
                    rightCount = numRows - 1;
                }else{
                    rightCount = 0;
                }
            }
            j += flag;
            // 判断k 什么时候右移
            if (rightCount > 0) {
                k++;
                rightCount -=1;
            }
        }
        for (char[] value : values) {
            for (char c : value) {
                if (c == 0){
                    System.out.print(" ");
                }else {
                    System.out.print(c);
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        // convert3("PAYPALISHIRING",3);
        float a =
                111111111111111111111111111111111111111.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999F;
        System.out.println(a>2);

    }
}
