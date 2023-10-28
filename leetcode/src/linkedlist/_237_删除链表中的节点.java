/**
 *
 * https://leetcode.cn/problems/delete-node-in-a-linked-list/
 *
 */

public class _237_删除链表中的节点 {

    public void deleteNode(ListNode node) {//传入的参数->要删除的节点
        node.val = node.next.val;//下一个节点的值覆盖要删除的节点的值
        node.next = node.next.next;//要删除的节点的引用改为下一个节点的引用即可
    }
}
