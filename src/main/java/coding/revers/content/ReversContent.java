package coding.revers.content;

import coding.entity.ListNode;
import coding.link.reverse.huisu.LinkReverse;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

/**
 * @author xpmiao
 * @date 2023/6/16
 */
public class ReversContent {
    /**
     * 判断链表是否是回文 在不使用额外空间的前提下实现
     * 1. 通过递归压栈的方式判断和header 节点是否相同。存在不同则就不是回文链表
     */
    @Test
    public void testReverseContent(){
        ListNode root = ListNode.build(1, 2, 1,1);
        originHead = root;
        reverseContent(root);
        System.out.println(isReverse);
    }
    ListNode originHead;
    boolean isReverse = true;
    ListNode reverseContent(ListNode root){
        if (root.next==null) {
            // 这里提前返回 避免node 空节点的问题
            return root;
        }
        ListNode listNode = reverseContent(root.next);
        if (listNode.val != originHead.val) {
            isReverse = false;
        }
        originHead = originHead.next;
        return root;
    }
    public static void change(BigDecimal one){
        one = BigDecimal.ZERO;
    }
    public static <T> Function<T,Function<T,Void>> func(T str){
        AtomicInteger atomicInteger = new AtomicInteger();
        return (T)->{
            System.out.println(atomicInteger.getAndIncrement());
            return  null;
        };
    }
    public static void main(String[] args) {
        Function<String, Function<String, Void>> func = func("1");
        func.apply("1");
        func.apply("1");
        func.apply("1");
    }
    @Test
    public void ma(){
        System.out.printf("%099d%n",111);
    }
}
