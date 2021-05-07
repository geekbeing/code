/* 
题目15
描述：输入一个链表，反转链表后，输出新链表的表头
 */
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode ReverseList(ListNode head) {
        ListNode pre = null, cur = head, tmp = null;
        
        if(cur == null || cur.next == null) //链表长度为 0 或 1 
            return cur;
        
        while(cur.next != null){
            tmp = cur.next; //保存下一个节点
            cur.next = pre; //当前节点指向前一个节点
            
            pre = cur;
            cur = tmp; //pre、cur后移一个节点            
        }        
        cur.next = pre; //最后一个节点指向前面的节点
        
        return cur;
    }
}