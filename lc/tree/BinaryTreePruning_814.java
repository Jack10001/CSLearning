package tree;

import java.util.Stack;

public class BinaryTreePruning_814 {
	public TreeNode pruneTree(TreeNode root) {
	    if(root==null) return null;
	    if(root.left==null && root.right==null && root.val==0) return root;
		Stack<TreeNode> stack=new Stack<>();
		stack.push(root);
		boolean is_adjusted=false;
		while(!stack.isEmpty()) {
			TreeNode curNode=stack.pop();
			if(curNode.left!=null && isUnivalTree(curNode.left)) {
				curNode.left=null;
				is_adjusted=true;
			}
			if(curNode.right!=null && isUnivalTree(curNode.right)) {
				curNode.right=null;
				is_adjusted=true;
			}
			if(!is_adjusted) {
				if(curNode.left!=null) stack.push(curNode.left);
				if(curNode.right!=null) stack.push(curNode.right);
			}else {
				stack.push(curNode);
			}
			is_adjusted=false;
			
		}
		return root;
	        
	    }

	   public boolean isUnivalTree(TreeNode root) {
	        return dfs(root, 0);
	    }
	    private boolean dfs(TreeNode node, int val){
	        if (node == null)
	            return true;
	        return (node.val == val) && dfs(node.left, val) && dfs(node.right, val);
	    }
}
class Solution_814 {
    public TreeNode pruneTree(TreeNode root) {
        if (root==null || pruneSubTree(root)==0) return null;
        else return root;
    }
    public int pruneSubTree(TreeNode root) {
        if (root==null)return 0;
        else if (root.left==null && root.right==null) return root.val;
        int pruneLeft = pruneSubTree(root.left);
        if (pruneLeft==0) root.left = null;
        int pruneRight = pruneSubTree(root.right);
        if (pruneSubTree(root.right)==0) root.right = null;
         return root.val + pruneLeft + pruneRight;
    }
}