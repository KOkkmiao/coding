package coding.twopoint;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

/**
 * @Author: author
 * @Description:
 * @Date: 2024/11/7 9:16 上午
 * @Version: 1.0
 */
public class 求谁能先取到 {
    /**
     * 给你两个 正 整数 x 和 y ，分别表示价值为 75 和 10 的硬币的数目。
     *
     * Alice 和 Bob 正在玩一个游戏。每一轮中，Alice 先进行操作，Bob 后操作。每次操作中，玩家需要拿走价值 总和 为 115 的硬币。如果一名玩家无法执行此操作，那么这名玩家 输掉 游戏。
     *
     * 两名玩家都采取 最优 策略，请你返回游戏的赢家。
     * 如果两边都能取到则后者赢
     * 为了凑够 115 =
     * 75 + 40  1 75 4 10
     *
     */
    public String getNums(int x,int y){
        int opt = Math.min(x / 1, y / 4);
        return opt % 2 == 1 ? "Alice" : "Bob";
    }
}
