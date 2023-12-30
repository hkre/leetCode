package main.java.linkedlist;

public class MyLinkedList {

    // 初始化dummy
    private ListNode dummy = new ListNode();
    // 初始化链表tail指针
    private ListNode tail = dummy;
    // 初始化链表的长度，此时为0
    private int length = 0;

    public MyLinkedList() {

    }

    private ListNode getPrevNode(int index) {
        /*返回index结点的前驱结点，如果index不存在，那么返回dummy*   */
        // 初始化front与back，分别一前一后
        ListNode front = dummy.next;
        ListNode back = dummy;
        // 在查找的时候，front与back总是一起走
        for (int i = 0; i < index && front != null; i++) {
            back = front;
        }
        front = front.next;
        // 把back做为prev并且返回
        return back;
    }


    public int get(int index) {
        // 获取链表中第 index 个结点的值。如果索引无效，则返回-1。
        //index从0开始
        if (index < 0 || index >= length) {
            return -1;
        }
        //因为getPrevNode总是返回有效的结点，所以可以直接取值
        return getPrevNode(index).next.val;
    }

    public void addAtIndex(int index, int val) {
        if (index > length) {
            // Case 1.如果index 大于链表长度，则不会插入结点。
            return;
        } else if (index == length) {
            // Case 2.如果index 等于链表的长度，则该结点将附加到链表的未
            addAtTail(val);
        } else if (index <= 0) {
            // Case 3.如果index小于0，则在头部插入结点。
            addAtHead(val);
        } else {
            // Case 4.
            // 得到index之前的结点pre
            ListNode pre = getPrevNode(index);//在pre的后面添加新结点
            ListNode p = new ListNode(val);
            p.next = pre.next;
            pre.next = p;// 注意修改长度
            length++;
        }
    }

    // 如果索引index 有效，则删除链表中的第 index 个节点。
    public void deleteAtIndex(int index) {
        // Case 1.如果index无效，那么什么也不做。
        if (index < 0 || index >= length) {
            return;
        }
        // Case 2.删除index结点
        // step 1.找到index前面的结点
        ListNode pre = getPrevNode(index);
        // step 2.如果要删除的是最后一个结点，那么需要更改tail指针
        if (tail == pre.next) {
            tail = pre;
        }
        // step.3 进行删除操作。并修改链表长度。
        pre.next = pre.next.next;
        length--;

    }

    public void addAtTail(int val) {
//        f*code here:将值为 val 的结点追加到链表尾部*
        // 尾部添加一个新结点
        tail.next = new ListNode(val);
        // 移动tail指针
        tail = tail.next;
// 链表长度+1
        length++;
    }

    public void addAtHead(int val) {
//        !*code here: 插入值val的新结点，使它成为链表的第一个结点*
// 生成一个结点，存放的值为val
        ListNode p = new ListNode(val);
// 将p.next指向第一个结点
        p.next = dummy.next;
//dummy.next指向新结点，使之变成第一个结点
        dummy.next = p;
//注意动静结合原则，添加结点时，注意修改tail指针。
        if (tail == dummy) {
            tail = p;
        }
        length++;
    }

    public ListNode reverseList(ListNode head) {
        // 建立一个新的带假头的新链表
        ListNode dummy = new ListNode();
        // 开始遍历旧链表
        while (head != null) {
            ListNode tmp = head.next;
// 把旧链表中的节点取出来，采用头部插入的方法添加到新链
            head.next = dummy.next;
            dummy.next = head;
            head = tmp;
        }
// 返回新链表的头，注意，不要返回dummy!!
        return dummy.next;
    }


}


