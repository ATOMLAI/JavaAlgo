package array_and_linkedlist;

import utils.ListNode;
import utils.PrintUtil;

public class linked_list {

    /* 在链表的节点n0 之后插入节点 P */
    static void insert(ListNode n0, ListNode P){//传入的参数1.链表的某个节点 2.新插入的节点P
        ListNode n1 = n0.next;
        P.next = n1;
        n0.next = P;
    }

    /*  删除链表的节点 n0 之后的首个节点 */
    static void remove(ListNode n0){//传入的参数:链表的某个节点
        if (n0.next == null)
            return;
        //n0 -> p -> n1
        ListNode P = n0.next;
        ListNode n1 = P.next;
        n0.next = n1;
    }

    /*  访问链表中索引为index的节点 */
    static ListNode access(ListNode head, int index){//传入的参数1.链表的头节点 2.索引
        for (int i = 0; i < index; i++) {
            if (head == null)
                return null;
            head = head.next;
        }
        return head;//此时的head就是head.index
    }

    /*  在链表中查找值为target的首个节点 */
    static int find(ListNode head, int target){//传入的参数1.链表的头节点 2.值为target
        int index = 0;
        while (head != null){
            if (head.val == target)
                return index;
            head = head.next;
            index++;
        }
        return -1;
    }

    /*  Driver Code */
    public static void main(String[] args) {
        /*  初始化链表 */
        //初始化各个节点
        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(4);

        //构建引用指向
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println("初始化的链表为");
        PrintUtil.printLinkedList(n0);

        /*  插入节点 */
        insert(n0, new ListNode(0));
        System.out.println("插入节点后的链表为");
        PrintUtil.printLinkedList(n0);

        /*  删除节点 */
        remove(n0);
        System.out.println("删除节点后的链表为");
        PrintUtil.printLinkedList(n0);

        /*  访问节点 */
        ListNode node = access(n0,3);
        System.out.println("链表中索引3处的节点的值 = " + node.val);

        /*  查找节点 */
        int index = find(n0,2);
        System.out.println("链表中值为2的节点的索引 = " + index);
    }

}
