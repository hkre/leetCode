package main.java.linkedlist;

import java.util.HashMap;
import java.util.List;

/***
 *
 @author chenfeifei
 @Description
 @date 2023年12月29日 9:33
 */
public class LinkListDemo {

    public static void main(String[] args) {
        //
        int[] nums = {1, 2, 6, 3, 4, 5, 6};



    }


    public static ListNode removeElements1(ListNode head, int val) {
        //创建一个新的链表
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        ListNode p = head;
        //如果值等于val就删除
        while (p != null) {
            //往新链表中插入数据
            if (p.val != val) {
                tail.next = p;
                tail = p;
            }

            p = p.next;

        }
        tail.next = null;
        return dummy.next;
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        ListNode p = head;

        while (p != null) {
            if (p.val != val) {
                tail.next = p;
                tail = p;
            }
            p = p.next;
        }
        tail.next = null;
        return dummy.next;
    }


    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        ListNode p = head;
        while (p != null) {
            ListNode temp = p.next;
            p.next = dummy.next;
            dummy.next = p;

            if (tail == dummy) {
                tail = p;
            }

            p = temp;

        }

        return dummy.next;
    }

    public ListNode swapPairs(ListNode head) {
        ListNode oddDummy = new ListNode();
        ListNode oddTail = oddDummy;
        ListNode evenDummy = new ListNode();
        ListNode evenTail = evenDummy;


        int temp = 0;
        int i = 0;
        ListNode p = head;
        while (p != null) {
            ListNode tempNext = p.next;//注意用临时变量
            temp = i % 2;
            if (temp == 0) {
                evenTail.next = p;
                evenTail = p;
            } else {
                oddTail.next = p;
                oddTail = p;
            }
            p = tempNext;
            i++;
        }
        oddTail.next = null; //注意两个链表的收尾
        evenTail.next = null;
        return getListNode(oddDummy.next, evenDummy.next);


    }

    private ListNode getListNode(ListNode oddDummy, ListNode evenDummy) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (oddDummy != null || evenDummy != null) {
            //
            if (oddDummy != null) {
                tail.next = oddDummy;
                tail = oddDummy;
                oddDummy = oddDummy.next;
            }
            if (evenDummy != null) {
                tail.next = evenDummy;
                tail = evenDummy;
                evenDummy = evenDummy.next;
            }
        }
        tail.next = null;
        return dummy.next;
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode p = dummy;
        ListNode tail = dummy;
        int index = 0;

        while (tail != null && tail.next != null && index < n) {
            tail = tail.next;
            index++;
        }

        while (tail != null && tail.next != null) {
            p = p.next;
            tail = tail.next;
        }


        if (n == index) {
            p.next = p.next.next;
        }

        return dummy.next;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        ListNode headADummy = new ListNode(); //因为直接遍历不需要头结点
//        headADummy.next = headA;
        ListNode p = headA;

//        ListNode headBDummy = new ListNode();
//        headBDummy.next = headB;
        ListNode temp = headB;

        HashMap<ListNode, Integer> hashMap = new HashMap<>();

        while (p != null) {
            if (!hashMap.containsKey(p)) {
                hashMap.put(p, 1);
            } else {
                Integer time = hashMap.get(p);
                hashMap.put(p, time + 1);
            }
            p = p.next;
        }

        while (temp != null) {
            if (hashMap.containsKey(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;

    }


    public ListNode hasCycle(ListNode head) {
        // 空链表和只有一个结点的链表的实现。
        if (head == null || head.next == null) {
            return null;
        }
        //分别设置两个快慢指针，他们都从head出发。
        // s1表示慢指针，一次只走一步
        // s2表示快指针，一次走两步
        ListNode s1 = head;
        ListNode s2 = head;
        ListNode temp = null;
        // 始走动两个指针
        // 当相遇到的时候就停下来
        while (s2 != null && s2.next != null) {
            s2 = s2.next.next;
            s1 = s1.next;
            if (s1 == s2) {
                temp = s1;
                break;
            }
        }

        if (s1 != s2) {
            return null;
        }

        //s1指针重新指向链表head，
        // 从head出发
        s1 = head;
        // s2指针此时位于相遇的位置
        // 然后两个指针一起走
        while (s1 != s2) {
            s1 = s1.next;
            s2 = s2.next;
            temp = s2;
        }
        //返回环形的入口结点return sl;
        return temp;
    }

}

