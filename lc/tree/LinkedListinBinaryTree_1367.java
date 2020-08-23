package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class LinkedListinBinaryTree_1367 {

	public boolean isSubPath(ListNode head, TreeNode root) {
		 //BFS+DFS
		if(head==null) return true;
		if(root==null) return false;
		Queue<TreeNode> queue=new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode curNode=queue.poll();
			if(checkPath(root, head))
				return true;
			if(curNode.left!=null) queue.add(curNode.left);
			if(curNode.right!=null) queue.add(curNode.right);
		} 
		return false;
	}
	 private boolean checkPath(TreeNode root,ListNode head) {
//		 Stack<TreeNode> stack=new Stack<>();
//		 stack.push(root);
//		 TreeNode curNode=null;
//		 while(!stack.isEmpty() && head!=null) {
//			 curNode=stack.pop();
//			 if(curNode.val!=head.val) {
//				 continue;
//			 }
//			 if(curNode.val==head.val) {
//				 head=head.next;
//			 }
//				 
//		     if(curNode.right!=null) stack.push(curNode.right);
//			 if(curNode.left!=null) stack.push(curNode.left);
//			
//			 
//		 }
		  // if the list has ended
	        if(head==null)
	            return true;
	        // if the list hasnt ended but tree has
	        if(root==null)
	            return false;

	        if(root.val!=head.val) return false;
	        return (checkPath(root.left, head.next) ||
	                                         checkPath(root.right, head.next));
		
	 }

}


/*
 枚举二叉树中的每个节点为起点往下的路径是否有与链表相匹配的路径。为了判断是否匹配我们设计一个递归函数 dfs(rt,\textit{head})dfs(rt,head) ，
 其中 rtrt 表示当前匹配到的二叉树节点，headhead 表示当前匹配到的链表节点，整个函数返回布尔值表示是否有一条该节点往下的路径与 headhead 节点开始的链表匹配，
 如匹配返回 \textit{true}true，否则返回 \textit{false}false ，一共有四种情况：

1.链表已经全部匹配完，匹配成功，返回 \textit{true}true

2.二叉树访问到了空节点，匹配失败，返回 \textit{false}false

3.当前匹配的二叉树上节点的值与链表节点的值不相等，匹配失败，返回 \textit{false}false

4.前三种情况都不满足，说明匹配成功了一部分，我们需要继续递归匹配，所以先调用函数 dfs(rt\rightarrow left,head\rightarrow next)dfs(rt→left,head→next) ，
其中 rt\rightarrow leftrt→left 表示该节点的左儿子节点， head\rightarrow nexthead→next 表示下一个链表节点，如果返回的结果是 \textit{false}false，说明没有找到相匹配的路径，需要继续在右子树中匹配，继续递归调用函数 dfs(rt\rightarrow right,head\rightarrow next)dfs(rt→right,head→next) 去找是否有相匹配的路径，
其中 rt\rightarrow rightrt→right 表示该节点的右儿子节点， head\rightarrow nexthead→next 表示下一个链表节点。

匹配函数确定了，剩下只要枚举即可，从根节点开始，如果当前节点匹配成功就直接返回 \textit{true}true ，否则继续找它的左儿子和右儿子是否满足，
也就是代码中的 dfs(root,head) || isSubPath(head,root->left) || isSubPath(head,root->right) ，然后不断的递归调用。

 */


class Solution{
public boolean isSubPath(ListNode head, TreeNode root) {
		 //BFS+DFS
	  if(head==null) return true;
      if(root==null) return false;
      if(checkPath(root,head)) return true;//当前节点
      return isSubPath(head,root.left)|| isSubPath(head,root.right);//判断左子树或右子树
	}
	 private boolean checkPath(TreeNode root,ListNode head) {
		  // if the list has ended
	        if(head==null)
	            return true;
	        // if the list hasnt ended but tree has
	        if(root==null)
	            return false;

	        if(root.val!=head.val) return false;
	        return (checkPath(root.left, head.next) ||
	                                         checkPath(root.right, head.next));
		
	 }
}
