/* 题目
描述：给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。 
*/
/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
/* 
	快慢指针法
1. 快指针走两步，慢指针走一步，
2. 两指针指针相遇时，快指针从链表头重新开始，每次走一步，
3. 再次相遇时即为环的入口
边界：链表空，无环
*/
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null || pHead.next == null)
            return null;
        ListNode fast = pHead, slow = pHead;
        //if(fast.next == pHead)
        //    return pHead;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                fast = pHead;
                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }       
        return null;

    }
}