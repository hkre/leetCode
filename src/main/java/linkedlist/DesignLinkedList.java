package main.java.linkedlist;

public class DesignLinkedList {
    class Node {
        public int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node() {

        }
    }

    ListNode dummy = new ListNode();
    ListNode tail = dummy;
    int length = 0;

    public DesignLinkedList() {

    }

    public int get(int index) {
        if (index < 0 || index >= length) {
            return -1;
        }
        return this.getPrevNode(index).next.val;
    }

    public void addAtTail(int val) {
        ListNode cur = new ListNode(val);
        tail.next = cur;
        tail = tail.next;
        length++;
    }

    public void addAtHead(int val) {
        ListNode cur = new ListNode(val);
        cur.next = dummy.next;
        dummy.next = cur;

        if (dummy == tail) {
            tail = cur;
        }
        length++;
    }

    public void addAtIndex(int index, int val) {
        if (index > length) {
            return;
        } else if (index < 0) {
            this.addAtHead(val);
        } else if (index == length) {
            this.addAtTail(val);
        } else {
            ListNode back = this.getPrevNode(index);
            ListNode node = new ListNode(val);
            node.next = back.next;
            back.next = node;
            length++;
        }


    }


    public ListNode getPrevNode(int index) {
        ListNode back = dummy;
        ListNode front = dummy.next;
        for (int i = 0; i < index && front != null; i++) {
            back = front;
            front = front.next;
        }
        return back;

    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= length) {
            return;
        }
        ListNode back = this.getPrevNode(index);
        if (back.next == tail) {
            tail = back;
        }
        back.next = back.next.next;
        length--;
    }


}
