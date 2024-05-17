package coding.entity;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    public static  ListNode build(int ...val){
        ListNode head = null,current = null;

        for (int i : val) {
            if (current == null){
                current = new ListNode(i);
                head = current;
                continue;
            }
            current.next = new ListNode(i);
            current = current.next;
        }
        return head;
    }
    public static void main(String[] args) {
        System.out.println(build(1, 2, 3, 4, 5));
    }
    @Override
    public String toString() {
        return "{" +
                "val=" + val +
                ", next->" + next +
                '}';
    }
}