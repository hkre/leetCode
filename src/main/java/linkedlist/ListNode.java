package main.java.linkedlist;

/***
 *
 @author chenfeifei
 @Description
 @date 2023年12月29日 9:34
 */
public class ListNode {
    private int val;

    private ListNode listNode;

    public ListNode() {
    }

    private ListNode(int val) {
        this.val = val;
    }

    private ListNode(int val, ListNode next) {
        this.val = val;
        this.listNode = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getListNode() {
        return listNode;
    }

    public void setListNode(ListNode listNode) {
        this.listNode = listNode;
    }
}
