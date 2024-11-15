package coding.罗马数字转化;

/**
 * @Author: author
 * @Description:
 * @Date: 2024/11/15 10:01 上午
 * @Version: 1.0
 */
public class code {
    /**
     * 七个不同的符号代表罗马数字，其值如下：
     *
     * 符号	值
     * I	1
     * V	5
     * X	10
     * L	50
     * C	100
     * D	500
     * M	1000
     * 罗马数字是通过添加从最高到最低的小数位值的转换而形成的。将小数位值转换为罗马数字有以下规则：
     *
     * 如果该值不是以 4 或 9 开头，请选择可以从输入中减去的最大值的符号，将该符号附加到结果，减去其值，然后将其余部分转换为罗马数字。
     * 如果该值以 4 或 9 开头，使用 减法形式，表示从以下符号中减去一个符号，例如 4 是 5 (V) 减 1 (I): IV ，9 是 10 (X) 减 1 (I)：IX。仅使用以下减法形式：4 (IV)，9 (IX)，40 (XL)，90 (XC)，400 (CD) 和 900 (CM)。
     * 只有 10 的次方（I, X, C, M）最多可以连续附加 3 次以代表 10 的倍数。你不能多次附加 5 (V)，50 (L) 或 500 (D)。如果需要将符号附加4次，请使用 减法形式。
     * 给定一个整数，将其转换为罗马数字。
     *
     */
    public String convertNumber(int num){
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] mapValue = {
                "M", "CM",
                "D", "CD",
                "C", "XC",
                "L", "XL",
                "X", "IX",
                "V", "IV",
                "I",
        };
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < value.length; i++) {
            int number = value[i];
            String lName = mapValue[i];
            while (num > number) {
                num  -=number;
                stringBuilder.append(lName);
            }
            if (num==0){
                break;
            }
        }
        return stringBuilder.toString();
    }
}
