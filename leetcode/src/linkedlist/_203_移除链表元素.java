/**
 * https://leetcode.cn/problems/remove-linked-list-elements/
 */
public class _203_移除链表元素 {
    //链表移除->除头节点外:找到要移除节点的前一个节点node,node的指针指向要移除节点的下一个节点的值
    //头节点:1.如果要删除的节点是头节点的话->head = head.next 2.使用虚拟头节点->统一处理逻辑


    /*
        1.递归->链表定义具有递归性质->链表题可以用递归的方法求解
        1.对给定的链表,首先对除了头节点head意外的节点进行删除操作
        2.判断head的节点值是否等于给定的val
        3.若head.val == val ->head需要被删除->删除操作后的头节点为head.next
        4.若head.val != bal ->head保留->删除操作后的头节点为head
     */
    public ListNode removeElements(ListNode head, int val){
        //边界值判断
        if (head == null){
            return head;
        }
        //removeElements(head.next,val)->递归地删除链表总所有值为val的节点
        //整个过程会不断递归地删除链表中所有值为val的节点,直到链表中没有值为val的节点为止
        head.next = removeElements(head.next,val);
        return head.val == val ? head.next : head;
    }

    /**
     * 添加虚拟头节点方式
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head,int val){
        if (head == null) {
            return head;
        }

        //因为删除可能涉及到头节点,所以设置dummy节点,统一操作
        //新建一个虚拟头节点,值为-66, 指针指向头节点
        ListNode dummy = new ListNode(-66, head);
        //前一个节点
        ListNode pre = dummy;
        //临时指针->用来遍历列表
        ListNode cur = head;

        while (cur != null){
            if (cur.val == val){
                //前一个节点的指针指向后一个节点
                pre.next = cur.next;
            }else {
                //前一个节点赋值为现在节点
                pre = cur;
            }
            //指针向后走一个节点->遍历
            cur = cur.next;
        }
        return dummy.next;//新的头节点->不能返回head,因为head可能已经被删了
    }

    /**
     * 不添加虚拟节点方式
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements3(ListNode head, int val){

        //1.首节点不为null,且首节点的值==target->直接删除
        while (head != null && head.val == val){
            head = head.next;
        }

        //2.首节点为null,提前退出
        if (head == null) {
            return head;
        }

        //3.已确定首节点的值!=target
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null){
            if (cur.val == val){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    /**
     * 不添加 dummy Node and pre Node 方式
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements4(ListNode head, int val){
        while (head != null && head.val == val){
            head = head.next;
        }

        ListNode cur = head;
        while (cur != null){
            while (cur.next != null && cur.next.val == val){
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;
    }
}
