package coding.字符串转整数;

/**
 * @Author: author
 * @Description:
 * @Date: 2024/11/12 10:02 上午
 * @Version: 1.0
 */
public class code {
    public int myAtoi(String s) {
        int i = 0;
        char first = s.charAt(i);
        int value = 0;
        boolean negative = false;
        if (first == '-') {
            negative = true;
            i++;
        }else{
            i++;
        }
        // 除空格 除0
        while (i<s.length()&& s.charAt(i)==' ') i++;
        while (i<s.length()&& s.charAt(i)=='0') i++;
        for (int j = i; j <s.length() ; j++) {
            char v = s.charAt(j);
            if (v<'0' || v>'9'){
                break;
            }
            value = value*10+v;
            // 判断32位最大值 和负数最大值。

        }
    }
}
