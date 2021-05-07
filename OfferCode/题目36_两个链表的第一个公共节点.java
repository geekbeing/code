/* 
题目36
描述：输入两个链表，找出它们的第一个公共结点。
（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
/* 
方法1（优选）：截取长的链表，使两个链表长度相同，然后同时遍历，
首个相同节点即为第一个公共节点
 */
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1, p2 = pHead2;
        if(p1 == null || p2 == null)
             return null;
        int len1 = 0, len2 = 0, n  = 0;
        
        while(p1 != null){
            len1++;
            p1 = p1.next;
        }
        while(p2 != null){
            len2++;
            p2 = p2.next;
        }
        // ***链表head要重置为表头
        p1 = pHead1; 
        p2 = pHead2;
        if(len1 >= len2){
            n = len1 - len2;
            while(n > 0){
                p1 = p1.next;
                n--;
            }
        }
        else{
            n = len2 - len1;
            while(n > 0){
                p2 = p2.next;
                n--;
            }
        }
        
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}

/* 
方法2：利用哈希表
对两个链表一次存入哈希表，当出现首个相同哈希值的即为第一个公共节点
缺点：需要O(n+m)的空间复杂的
 */