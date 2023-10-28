/**
 * https://leetcode.cn/problems/middle-of-the-linked-list/
 */
public class _876_链表的中间结点 {
    /**
     * 1.遍历链表,将遍历到的元素依次放入数组[] A
     * -> 如果遍历得到 N个元素那么链表以及数组的长度为N
     * -> 对应的中间节点为 A[N/2]
     * @param head
     * @return
     *
     * 时间复杂度：O(N)，其中 N是给定链表中的结点数目。
     * 空间复杂度：O(N)，即数组 A 用去的空间。
     */
    public ListNode middleNode1(ListNode head) {
        ListNode[] A = new ListNode[100];
        int t = 0;
        while (head != null){
            A[t++] = head;
            head = head.next;
        }
        return A[t/2];
    }

    /**
     * 单指针法:对链表进行两次遍历
     * 1.第一次遍历时,统计链表中的元素个数 N
     * 2.第二次遍历到N/2个元素时(链表的首节点为第 0 个元素),将该元素返回即可
     * @param head
     * @return
     *
     * 时间复杂度 O(N) ->N是给定链表的节点数目
     * 空间复杂度 O(1) ->只需要常数空间存放变量和指针
     */
    public ListNode middleNode2(ListNode head) {
        //第一次遍历链表->记录节点数n
        int n = 0;
        ListNode cur = head;
        while (cur != null){
            ++n;
            cur = cur.next;
        }
        //第二次遍历链表->循环0,1,2->3次指向右边的中间节点
        int k = 0;
        cur = head;
        while (k < n/2){
            ++k;
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 快慢指针: 慢指针一次只走1步,快指针一次只走2步,一个在前,一个在后,同时走
     * ->快慢指针的前进方向相同,且它们步伐的差是恒定的->利用确定性取解决链表问题
     *
     * 1.若快指针可以前进的条件是->当前快指针和当前快指针的下一个节点都非空
     * ->当节点个数为奇数时,slow节点落在链表的中间节点
     * ->当节点个数为偶数时,slow节点落在靠右的中间节点
     *
     * 2.若快指针可以前进的条件是->当前快指针下一个节点和下下个节点都非空
     * ->当节点个数为奇数时,slow节点落在链表的中间节点
     * ->当节点个数为偶数时,slow节点落在靠左的中间节点
     * @param head
     * @return
     */
    public ListNode middleNode3(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

