/* 
题目26
描述：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
要求不能创建任何新的结点，只能调整树中结点指针的指向。 
*/
//方法1：中序遍历递归直接建立链接。 时间O(n)，空间O(1)
//方法2：中序遍历递归，存储节点，二次遍历时建立链接。时间O(n)，空间O(n)
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null)
            return null;
        
        TreeNode headNode = null; 
        //中序遍历递归
        middleorderTraversal(pRootOfTree, null);
        
        headNode = pRootOfTree;
        while(headNode.left != null){
            headNode = headNode.left;
        }        
        return headNode;
    }
    //方法1：中序遍历递归
    public TreeNode middleorderTraversal(TreeNode pRootOfTree, TreeNode lastNodeInList){
        // TreeNode lastNodeInList = null;
        if(pRootOfTree == null)
            return null;
        //左子树
        if(pRootOfTree.left != null){
            lastNodeInList = middleorderTraversal(pRootOfTree.left, lastNodeInList);
        }
        //key point 把当前节点与其左子树的最大节点建立链接
        pRootOfTree.left = lastNodeInList;
        if(lastNodeInList != null)
            lastNodeInList.right = pRootOfTree;        
        
        //右子树
        lastNodeInList = pRootOfTree;
        if(pRootOfTree.right != null){
            lastNodeInList = middleorderTraversal(pRootOfTree.right, lastNodeInList);
        }        
        return lastNodeInList;
    }
}