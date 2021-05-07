/* 
题目03
描述：输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/

// 方法1：反转链表
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> lis = new ArrayList();
        ListNode tmp=null, pre=null, cur=listNode;       
        
        while(cur != null){            
            tmp = cur.next; //保存下一个节点
            cur.next = pre;
            pre = cur;  //cur、tmp节点后移
            cur = tmp;
        }
        
        while(pre != null){
            lis.add(pre.val);
            pre = pre.next;
        }
        return lis;
    }
}

// 方法2：递归
/* import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> lis = new ArrayList();
		
        if(listNode == null )
            return lis;
        lis = printListFromTailToHead(listNode.next);
        
        lis.add(listNode.val);
        return lis;
    }
} */
