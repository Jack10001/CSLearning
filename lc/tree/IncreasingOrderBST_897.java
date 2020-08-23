package tree;


import java.util.ArrayList;
import java.util.List;

public class IncreasingOrderBST_897 {
	private List<Integer> ans=new ArrayList<>();  
	private TreeNode head=null;
	public TreeNode increasingBST(TreeNode root) {
		  /**
		   * 思路：1.使用中序遍历将结果存储在List中
		   *     2.通过List进行类似单链表二叉树的构造*/
		inorder(root);
		construct();
		return head;
	        
	 }
	private void inorder(TreeNode root) {
		if(root==null) return;
		//L N R
		inorder(root.left);
		ans.add(root.val);
		inorder(root.right);
	}
	private void construct() {
		if(ans==null) return;
		TreeNode tmpNode=null;
		head=new TreeNode(ans.get(0));
		head.left=null;
		head.right=null;
		tmpNode=head;
		for(int i=1;i<ans.size();i++) {
			TreeNode curNode=new TreeNode(ans.get(i));
			curNode.left=null;
			tmpNode.right=curNode;
			tmpNode=curNode;
			
		}
		
		
	}
}

class Solution_897 {
	//通过增加一个节点，然后返回该节点的右子树即可
	TreeNode current;
	
	private void inorderTraversal (TreeNode root) {
		
		if (root != null) {
			inorderTraversal (root.left);
			
			root.left = null;
			current.right = root;
			current = root;
			
			inorderTraversal (root.right);
		}
	}
	
	public TreeNode increasingBST (TreeNode root) {
		
		TreeNode ans = new TreeNode (0);
		current = ans;
		inorderTraversal (root);
		return ans.right;
	}
}
