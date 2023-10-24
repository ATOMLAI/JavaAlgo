package utils;

/**
 * Definition for a singly-linked list node
 */
public class ListNode {//单向链表由多个节点组成->此类表示一个单向链表的节点
    public int val;//每个节点包含一个值
    public ListNode next;//每个节点包含一个指向下一节点的引用

    /**
     * 构造方法->初始化ListNode的值
     * @param x
     */
    public ListNode(int x){
        val = x;
    }

    /* Generate a linked list with an array */
    public static ListNode arrToLinkedList(int[] arr){
        ListNode dum = new ListNode(0);
        ListNode head = dum;
        for (int val : arr) {
            head.next = new ListNode(val);
            head = head.next;
        }
        return dum.next;
    }

    /* Get a list node with specific value from a linked list */
    public static ListNode getListNode(ListNode head, int val){
        while (head != null && head.val != val){
            head = head.next;
        }
        return head;
    }


}
