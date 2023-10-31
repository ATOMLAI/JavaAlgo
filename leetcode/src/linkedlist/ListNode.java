public class ListNode {

    //Definition for singly-linked list.

    //节点的值
    int val;

    //下一个节点->指针
    ListNode next;


    //节点的构造函数
    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
