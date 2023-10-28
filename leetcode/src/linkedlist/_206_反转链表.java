/**
 *
 * https://leetcode.cn/problems/reverse-linked-list/
 *
 */


public class _206_反转链表 {

    //递归->就是不断调用自己的函数方法
    public ListNode reverseList(ListNode head) {

//        if (head == null) //头节点为空->链表没有节点->返回null
//            return  null;//->return head
//        if (head.next == null)//头节点的引用为空->链表只有一个节点->返回头节点
//            return head;

        //找到边界点
        if (head == null || head.next == null)
            return head;

        //死循环
        ListNode newHead = reverseList(head.next);
        head.next.next = head;//->4的next指向5
        head.next = null;//->5的next指向null
        return newHead;

        //如果reverseList()这个函数方法编写成功->效果为 ListNode newHead = reverseList(head)
        //ListNode newHead = reverseList(head.next); -> 1->2->3->4->null
        //->上面那句代码表示反转成功->只差头节点的反转
    }

    //迭代
    public ListNode reverseList2(ListNode head){
        //边界条件检查
        if (head == null || head.next == null) return head;

        ListNode newHead = null;//反转后的链表的头节点
        while (head != null){
            ListNode tmp = head.next;//创建一个临时节点 tmp，用来存储当前节点 head 的下一个节点。
            head.next = newHead;//将当前节点 head 的下一个节点指向新链表头节点 newHead
            //->实际上将 head 从原链表中分离出来，并将其插入到新链表的头部
            newHead = head;//将新链表的头节点 newHead 移动到当前节点 head，此时 head 成为了新链表的新头节点。
            head = tmp;//将 head 指向临时节点 tmp，继续遍历原链表的下一个节点。
        }
        return newHead;
    }
}
