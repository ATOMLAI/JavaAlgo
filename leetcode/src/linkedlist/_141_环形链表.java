/**
 *
 * https://leetcode.cn/problems/linked-list-cycle/
 *
 *
 */


public class _141_环形链表 {
    public boolean hasCycle(ListNode head) {
        //边界条件
        if (head == null || head.next == null) return false;

        //快慢指针不能一开始在一起
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){//fast走完链表也没有和slow相遇->跳出循环
            if (slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    //复杂度->看数据规模->快指针走了n/2次->O(n)
}
