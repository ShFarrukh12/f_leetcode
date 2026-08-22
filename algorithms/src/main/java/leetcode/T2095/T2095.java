package leetcode.T2095;

import leetcode.ListNode;

public class T2095 {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }

        var slow = head;
        var fast = head.next.next;

        while (fast != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}


