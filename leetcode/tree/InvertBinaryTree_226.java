package tree;

public class InvertBinaryTree_226 {
	 TreeNode node;
	 public TreeNode invertTree(TreeNode root) {
	    //N
		if(root==null) return root;
		node=root.left;
		root.left=root.right;
		root.right=node;
		//L
		invertTree(root.left);
		//R
		invertTree(root.right);
		return root;

	    }
	 
}
