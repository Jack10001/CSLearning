package tree;

public class DiameterofBinaryTree_543 {
	private int max;
	public int diameterOfBinaryTree(TreeNode root) {
		max=0;
		helper(root);
		return max;
		}
	private int helper(TreeNode root){
		//1.姹傚嚭涓や釜鍙跺瓙鑺傜偣涔嬮棿鐨勮矾寰�
		//2.鎵惧埌鏈�澶ч暱搴�

		//---姹傛爲娣卞害鐨勫彉浣�---
		//姹傛爲娣卞害锛屼粠鍙跺瓙鑺傜偣寮�濮嬩竴灞備竴灞傚線涓婄疮鍔�
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

