package tree;

//O(nlogn)
//全局的判断

public class BalancedBinaryTree_110 {
	public boolean isBanlanced(TreeNode root) {
		//1.判断左右子树的高度差是否小于1
		//2.判断左子树是平衡树
		//3.判断右子树是平衡树
		if(root==null) return true;
		int left_height=height(root.left);
		int right_height=height(root.right);
		return (Math.abs(right_height-left_height)<=1 && isBanlanced(root.left) && isBanlanced(root.right));
	}
	
	private int height(TreeNode node) {
		if(node==null) return 0;
		return Math.max(height(node.left),height(node.right))+1;
	}
	

}

//O(n)
//改进点：以某个节点为根节点的子树不是平衡树，则整棵树就不是平衡树

class Solution2 {
	
	public boolean isBalanced(TreeNode root) {
		if(root==null) return true;
		Boolean balanced=new Boolean(true);
		height(root,balanced);
		return balanced;
	}
	private int height(TreeNode node,Boolean balanced) {
		if(node==null) return 0;
		int left_height=height(node.left,balanced);
		int right_height=height(node.right,balanced);
		int tree_height=Math.max(left_height, right_height)+1;
		if(Math.abs(left_height-right_height)>1)
			balanced=false;
		return tree_height;
	}

	
}