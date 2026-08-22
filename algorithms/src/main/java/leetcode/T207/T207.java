package leetcode.T207;

import leetcode.ListNode;

public class T207 {
    public ListNode reverseList(final ListNode head) {
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            ListNode tmp = current.next;
            current.next = prev;
            current = tmp;
            prev = current;
        }

        return prev;
    }
}
