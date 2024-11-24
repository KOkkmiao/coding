package coding.删除倒数第N个节点;

import coding.entity.ListNode;

/**
 * @Author: author
 * @Description:
 * @Date: 2024/11/24 10:16 下午
 * @Version: 1.0
 */
public class code {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode();
        // 有pre 的原因是如果head 就是要删除的倒数第N个节点。 那么head 就不是删除了。都节点就是 head.next 但是end 是向后走的。没法记录
        // 到这个数据。所以只能用一个前置节点在处理。另外 删除倒数第N个节点需要算到倒数第N+1个节点才可以。
        //  1  2 3  4  5 倒数第2 个节点是 4 所以n要走三步。 取到3 节点才能满足。 这里的pre 相当于 -1节点正好满足第一个while
        pre.next = head;
        ListNode star = head;
        ListNode end = pre;
        while(n !=0){
            star = star.next;
            n--;
        }
        while(star!=null){
            star = star.next;
            end = end.next;
        }
        end.next =end.next.next;
        end.next.next = null;
        return pre.next;
    }
}
