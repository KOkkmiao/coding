package org.coding.twopoint;

public class 丰富的字符串 {

    public static void main(String[] args) {
        System.out.println(expressiveWords("helllllooo",new String[]{"hello","helo","hi"}));
    }

    /**
     *  heeelllllooo
     *
     *  字符串的某个字符扩展的三个以上。
     *  能够匹配上的字符 hello
     *
     */
    public static int expressiveWords(String s, String[] words) {
        int result = 0;
        for (String word : words) {
            int i = 0,j= 0; // 初始化双指针。
            while(i<word.length()&&j<s.length()){
                char wordsChar = word.charAt(i);
                char sChar = s.charAt(j);
                // 先判断 wordChar 是否是重叠的字符串 重叠了 找出重叠个数。 给下边的schar 做减法 判断是否是大于3个
                for( ;i + 1<word.length()-1 &&word.charAt(i+1) == wordsChar;i++) {
                }

                //判断两个字符是否相同。 相同则 j 指针继续走
                // 不相同则判断 char 是否和 i++ 的值相同 相同则继续 不同则word 不匹配
                // 这里判断重复的字段个数是否是三个以上。
                while (wordsChar ==sChar && j<s.length()-1&& s.charAt(j+1)==wordsChar ) {
                    j++;
                    sChar = s.charAt(j);
                }
                //判断这里重复的个数是否和预期一样。  i==j || j-i >=2
                if (i==j || j-i >=2){
                    i++;
                    j++;
                }else{
                    // 是不合法的数据
                    break;
                }

                if (i==word.length() && j==s.length()){
                    // 获得一个结果
                    result++;

                }
            }
        }
        return result;
    }

}
