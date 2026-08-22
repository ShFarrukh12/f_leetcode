package leetcode.T707;

/**
 * Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
 * A node in a singly linked list should have two attributes: val and next. val is the value of the current node,
 * and next is a pointer/reference to the next node. If you want to use the doubly linked list, you will need one more
 * attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.
 *
 * Implement the MyLinkedList class:
 *
 * MyLinkedList() Initializes the MyLinkedList object.
 *
 * int get(int index) - Get the value of the indexth node in the linked list. If the index is invalid, return -1.
 *
 * void addAtHead(int val) - Add a node of value val before the first element of the linked list.
 * After the insertion, the new node will be the first node of the linked list.
 *
 * void addAtTail(int val)  - Append a node of value val as the last element of the linked list.
 *
 * void addAtIndex(int index, int val) - Add a node of value val before the indexth node in the linked list.
 * If index equals the length of the linked list, the node will be appended to the end of the linked list.
 * If index is greater than the length, the node will not be inserted.
 *
 * void deleteAtIndex(int index) - Delete the indexth node in the linked list, if the index is valid.
 */

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
class MyLinkedList {
    Integer val;
    Integer size = 0;
    MyLinkedList next;

    public MyLinkedList() {

    }

    MyLinkedList(final int val, final MyLinkedList myLinkedList) {
        this.next = myLinkedList;
        this.val = val;
    }

    public int get(int index) {
        for (int i = 1; i < index; i++) {
            next = next.next;
        }

        return next.val;
    }

    public void addAtHead(final int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(final int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }

        this.size++;

        for (int i = 1; i < index; i++) {
            next = next.next;
        }

        final var old = next.next;
        next.next = new MyLinkedList(val, old);
    }

    public void deleteAtIndex(int index) {
        int length = 0;
        var current_for_length = next;

        while (current_for_length.next != null) {
            length++;
            current_for_length = current_for_length.next;
        }

        if (index < 0 || index > length) {
            return;
        }

        for (int i = 1; i < index; i++) {
            next = next.next;
        }

        next.next = next.next.next;
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList(10, null);
        MyLinkedList linkedList1 = new MyLinkedList(15, linkedList);
        MyLinkedList linkedList2 = new MyLinkedList(20, linkedList1);
        MyLinkedList linkedList3 = new MyLinkedList(25, linkedList2);

        System.out.println(linkedList3.get(1));

        linkedList3.addAtIndex(2, 35);
        System.out.println(linkedList3.get(2));
    }
}
