package tree;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal_145 {

}

class Solution_145 { 
	private List<Integer> list; 
	 
	private void postOrderIter1(TreeNode root) {
		Stack<TreeNode> stack=new Stack<>();
	    TreeNode curNode;
	    stack.push(root);
	    while(!stack.isEmpty()) {
	    	curNode=stack.pop();
	    	while(curNode!=null) {
	    		stack.push(curNode);
	    		curNode=curNode.left;
	    	}
	    	curNode=curNode.right;
	    	
	    }
		
	}
	private void postOrderIter(TreeNode root) { 
		//后序遍历的迭代版可以使用两个栈去解决
		if(root == null) 
		return; 
		Stack<TreeNode> s1 = new Stack<>(); 
		Stack<TreeNode> s2 = new Stack<>(); 
		s1.push(root); 
		while(!s1.isEmpty()) 
		{ 
			TreeNode r = s1.pop(); 
			if(r==null) 
				continue; 
			s2.push(r); 
			if(r.left!=null) s1.push(r.left); 
			if(r.right!=null) s1.push(r.right); 
		} 
 
		while(!s2.isEmpty()) 
		{ 
			TreeNode r = s2.pop(); 
			list.add(r.val); 
		} 
	} 
 
	private void postOrderRec(TreeNode root) 
	{ 
		if(root == null) 
		return; 
		postOrderRec(root.left); 
		postOrderRec(root.right); 
		list.add(root.val); 
	} 
	 
	public List<Integer> postorderTraversal(TreeNode root) { 
		list = new ArrayList<>(); 
		//postOrderRec(root); 
		postOrderIter(root); 
		return list; 
	} 
} 