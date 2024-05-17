package coding.count;



import coding.entity.ListNode;

public class 两数之和链表 {
    /**
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return recursion(l1, l2, 0);
    }

    public ListNode recursion(ListNode l1, ListNode l2, int add) {
        if (l1 == null && l2 == null) {
            return add > 0 ? new ListNode(add) : null;
        }

        ListNode root = new ListNode();
        int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + add;

        root.val = sum % 10;
        root.next = recursion(l1 == null ? null : l1.next, l2 == null ? null : l2.next, sum / 10);
        return root;
    }
    public static void main(String[] args) {

    }
}
