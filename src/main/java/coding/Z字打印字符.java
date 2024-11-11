package coding;

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
}
