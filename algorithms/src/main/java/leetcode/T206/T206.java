package leetcode.T206;

public class T206 {
    public ListNode reverseList(final ListNode head) {
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            ListNode tmp = current.next;
            current.next = prev;
            current = tmp;
            prev = current;
        }

        return current;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) {this.val = val; this.next = next; }
    }
}
