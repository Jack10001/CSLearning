package tree;

import java.util.LinkedList;
import java.util.Queue;

public class UnivaluedBinaryTree_965 {
	//BFS
	public boolean isUnivalTree(TreeNode root) {
		if(root==null) return true;
		Queue<TreeNode> queue=new LinkedList<>();
		queue.add(root);
		TreeNode node=null,preNode=root;
		while(!queue.isEmpty()) {
			node=queue.remove();
			if(node.val!=preNode.val) return false;
			if(node.left!=null) queue.add(node.left);
			if(node.right!=null) queue.add(node.right);
			preNode=node;
		}
		return true;
	}

}
