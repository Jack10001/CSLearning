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
 ö�ٶ������е�ÿ���ڵ�Ϊ������µ�·���Ƿ�����������ƥ���·����Ϊ���ж��Ƿ�ƥ���������һ���ݹ麯�� dfs(rt,\textit{head})dfs(rt,head) ��
 ���� rtrt ��ʾ��ǰƥ�䵽�Ķ������ڵ㣬headhead ��ʾ��ǰƥ�䵽������ڵ㣬�����������ز���ֵ��ʾ�Ƿ���һ���ýڵ����µ�·���� headhead �ڵ㿪ʼ������ƥ�䣬
 ��ƥ�䷵�� \textit{true}true�����򷵻� \textit{false}false ��һ�������������

1.�����Ѿ�ȫ��ƥ���꣬ƥ��ɹ������� \textit{true}true

2.���������ʵ��˿սڵ㣬ƥ��ʧ�ܣ����� \textit{false}false

3.��ǰƥ��Ķ������Ͻڵ��ֵ������ڵ��ֵ����ȣ�ƥ��ʧ�ܣ����� \textit{false}false

4.ǰ��������������㣬˵��ƥ��ɹ���һ���֣�������Ҫ�����ݹ�ƥ�䣬�����ȵ��ú��� dfs(rt\rightarrow left,head\rightarrow next)dfs(rt��left,head��next) ��
���� rt\rightarrow leftrt��left ��ʾ�ýڵ������ӽڵ㣬 head\rightarrow nexthead��next ��ʾ��һ������ڵ㣬������صĽ���� \textit{false}false��˵��û���ҵ���ƥ���·������Ҫ��������������ƥ�䣬�����ݹ���ú��� dfs(rt\rightarrow right,head\rightarrow next)dfs(rt��right,head��next) ȥ���Ƿ�����ƥ���·����
���� rt\rightarrow rightrt��right ��ʾ�ýڵ���Ҷ��ӽڵ㣬 head\rightarrow nexthead��next ��ʾ��һ������ڵ㡣

ƥ�亯��ȷ���ˣ�ʣ��ֻҪö�ټ��ɣ��Ӹ��ڵ㿪ʼ�������ǰ�ڵ�ƥ��ɹ���ֱ�ӷ��� \textit{true}true �������������������Ӻ��Ҷ����Ƿ����㣬
Ҳ���Ǵ����е� dfs(root,head) || isSubPath(head,root->left) || isSubPath(head,root->right) ��Ȼ�󲻶ϵĵݹ���á�

 */


class Solution{
public boolean isSubPath(ListNode head, TreeNode root) {
		 //BFS+DFS
	  if(head==null) return true;
      if(root==null) return false;
      if(checkPath(root,head)) return true;//��ǰ�ڵ�
      return isSubPath(head,root.left)|| isSubPath(head,root.right);//�ж���������������
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
