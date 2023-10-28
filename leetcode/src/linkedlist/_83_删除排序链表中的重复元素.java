/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
 */
public class _83_删除排序链表中的重复元素 {

    /**
     * 因为给定的链表是排好序的->重复的元素在链表中的位置是连续的
     * ->对链表进行一次遍历,就可以删除重复元素
     * 1.将临时指针cur ->指向链表的头节点
     * 2.对链表进行遍历
     * 3.如果当前cur与cur.next对应的元素相同->将cur.next从链表中移除
     * 4.否则说明链表中已经不存在其他与cur对应的元素相同的节点->可以将cur指向cur.next
     * 5.遍历完整个链表后,返回链表的头节点即可
     * 6.当遍历到链表的最后一个节点时,cur.next为空节点,如果不加以判断,访问cur.next对应的元素会产生运行错误
     * ->只需要遍历到链表的最后一个节点,而不需呀遍历完整个链表
     *
     * 时间复杂度 O(n) -> n是链表的长度
     * 空间复杂度 O(1)
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        //如果已经有if(head == null) return head;
        //->潜台词就是head != null,那么while循环条件里没必要写cur != null -> cur.next != null
        //或者改为 while(cur != null && cur.next != null) {...} return head;
        ListNode cur = head;
        while (cur.next != null){
            if (cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }
}
