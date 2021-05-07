/* 
题目56
描述：在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 
例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
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
//双指针法，左指针指向重复节点的前一个节点，右指针用来删除重复节点
public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null || pHead.next == null)
            return pHead;
        ListNode headNode = new ListNode(Integer.MIN_VALUE);
        ListNode pre, cur;        
        headNode.next = pHead;
        pre  = headNode;
        cur  = pHead;
        boolean repeat = false;
        
        while(cur != null){
            while(cur.next != null && cur.val == cur.next.val){
                cur= cur.next;
                repeat = true;
            }
            
            if(repeat){
                repeat = false;
                pre.next = cur.next;
            }
            else
                pre = cur;
            
            cur = cur.next;
        }
        
        return headNode.next;
    }
}