/**
 * https://leetcode.cn/problems/design-linked-list/
 */

/**
 * 时间复杂度: 涉及 index 的相关操作为 O(index), 其余为 O(1)
 * 空间复杂度: O(n)
 */
public class _707_设计链表 {

    //单链表
    class ListNode {
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val) {
            this.val=val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class MyLinkedList {
        //size存储链表元素的个数
        int size;
        //虚拟头节点
        ListNode head;

        //初始化链表->构造方法
        public MyLinkedList() {
            size = 0;
            head = new ListNode(0);
        }


        //获取第index个节点的数值,注意index是从0开始的,第0个节点是头结点
        public int get(int index) {
            //如果index非法,返回-1
            if (index < 0 || index >= size){
                return -1;
            }
            ListNode currentNode = head;
            //包含一个虚拟头节点,所以查找第 index+1 个节点
            for (int i = 0; i <= index; i++) {
                currentNode = currentNode.next;
            }
            return currentNode.val;
        }

        //在链表最前面插入一个节点,等价于在第0个元素前添加
        public void addAtHead(int val) {
            addAtIndex(0,val);
        }

        //在链表的最后插入一个节点,等价于在(末尾+1)个元素前添加
        public void addAtTail(int val) {
            addAtIndex(size,val);
        }

        //在第index个节点之前插入一个新节点,例如index=0,那么新插入的节点为链表的新头节点
        //如果index等于链表的长度,则说明是新插入的节点为链表的尾节点
        //如果index大于链表的长度,则返回空
        public void addAtIndex(int index, int val) {
            if (index > size){
                return;
            }
            if (index < 0){
                index = 0;
            }
            size++;//->链表长度增加
            //找到要插入节点的前驱->遍历链表的固定写法
            ListNode pred = head;
            for (int i = 0; i < index; i++) {
                pred = pred.next;
            }
            ListNode toAdd = new ListNode(val);//新增链表节点
            toAdd.next = pred.next;
            pred.next = toAdd;
        }

        //删除第index个节点
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size){
                return;
            }
            size--;//->链表长度减少
            if (index == 0){
                head = head.next;
                return;
            }
            //找到要删除节点的前驱->遍历链表的固定写法
            ListNode pred = head;
            for (int i = 0; i < index; i++) {
                pred = pred.next;
            }
            pred.next = pred.next.next;
        }
    }
}
