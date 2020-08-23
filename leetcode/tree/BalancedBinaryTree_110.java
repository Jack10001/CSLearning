package tree;

//O(nlogn)
//ȫ�ֵ��ж�

public class BalancedBinaryTree_110 {
	public boolean isBanlanced(TreeNode root) {
		//1.�ж����������ĸ߶Ȳ��Ƿ�С��1
		//2.�ж���������ƽ����
		//3.�ж���������ƽ����
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
//�Ľ��㣺��ĳ���ڵ�Ϊ���ڵ����������ƽ���������������Ͳ���ƽ����

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