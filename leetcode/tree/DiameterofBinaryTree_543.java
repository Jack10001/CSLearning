package tree;

public class DiameterofBinaryTree_543 {
	private int max;
	public int diameterOfBinaryTree(TreeNode root) {
		max=0;
		helper(root);
		return max;
		}
	private int helper(TreeNode root){
		if(root==null) return 0;
		int l,r;
		l=helper(root.left);//求出左子树的深度
		r=helper(root.right);//求出右子树的深度
		if(l+r > max){//max中保存最终值
			max=l+r;
		}
		return Math.max(l, r)+1;//返回一个左子树和右子树中值比较大的，代表着左子树的直径要大于右子树的直径
	}

}

