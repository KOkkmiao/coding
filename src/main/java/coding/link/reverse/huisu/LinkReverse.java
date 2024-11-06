package coding.link.reverse.huisu;

import coding.entity.ListNode;
import org.junit.Test;

/**
 * @author xpmiao
 * @date 2023/6/7
 */
public class LinkReverse {
    /**
     * 链表翻转 递归写法
     * 1-> 2-> 3-> 4-> NUll
     * 从链表上分析已经是 判断到null 的时候找到最后的节点可以使用全局变量来保存这个节点
     */
    @Test
    public void pointReverse() {
        System.out.println(reverse(ListNode.build(1, 2, 3, 4, 5, 6)));
    }
    /**
     * 使用临时节点去
     */
    @Test
    public void reverseNPoint(){
        ListNode root = ListNode.build(1, 2, 3, 4, 5, 6);
        ListNode listNode = reverseNPoint(root, 2);
        root.next = otherNode;
        System.out.println(listNode);
    }
    /**
     * 从 m节点 翻转 n个节点
     */
    @Test
    public void reverseM_NPoint(){
        ListNode root = ListNode.build(1, 2, 3, 4, 5, 6);
        System.out.println(reverseM_NPoint(root,2,2));
    }
    ListNode reverseM_NPoint(ListNode root,int m, int n){
        if (m == 0) { // 这里和之前翻转n的链表一样
            return reverseNPoint(root,n);
        }
        // 如果是大于1 的则  这是迭代的思想
        // ListNode mNode = root;
        // ListNode pre = null;
        // while (m > 0) {
        //     pre = mNode;
        //     mNode = mNode.next;
        //     m--;
        // }
        // // 找到了m节点
        // ListNode listNode = reverseNPoint(mNode, n);
        // pre.next = listNode;
        // 如果使用递归思想则用一下代码 递归找到需要翻转的地方。
        root.next = reverseM_NPoint(root.next,m-1,n);
        return root;
    }

    ListNode otherNode;
    ListNode reverseNPoint(ListNode node,int n){
        // case
        if (n == 1) {
            // 这里就找到的最后的节点
            otherNode = node.next;
            return node;
        }
        ListNode last = reverseNPoint(node.next,n-1);

        node.next.next = node;
        // node.next = null;
        // 这里指定 临时
        node.next  = otherNode; // 这种写法不太好理解。 就是所有的前一个跳转的节点都指向 翻转节点之后的数据。 最终1 号node 就能衔接上了
        return last;
    }
    @Test
    public void pointReverse2(){
        System.out.println(pointRevers2(ListNode.build(1, 2, 3, 4, 5, 6)));
    }


    /**
     * 双指针翻转链表
     * @param node
     * @return
     */
    public ListNode pointRevers2(ListNode node) {
        ListNode pre = null;
        ListNode current = node;
        while (current != null) {
            ListNode tmpNext = current.next;
            current.next = pre;
            pre = current;
            current = tmpNext;
        }
        return pre;
    }
    public ListNode reverse(ListNode node) {
        // case
        if (node.next == null) {
            // 这里就找到的最后的节点
            return node;
        }
        ListNode last = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return last;
    }
}
