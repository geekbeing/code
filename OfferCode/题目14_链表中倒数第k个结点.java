/* 
题目14
描述：输入一个链表，输出该链表中倒数第k个结点。
 */
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
// 解法：快慢指针
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode slow = head, fast = head;
        if(fast == null || k <= 0) //链表空 或 k <= 0
            return null;
        for(int i = 1; i < k; i++){ //移动 k-1 个节点
            fast = fast.next;
            if(fast == null) // k > lenth
                return null;
        }
        
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}