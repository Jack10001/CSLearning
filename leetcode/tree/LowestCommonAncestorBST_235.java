package tree;

public class LowestCommonAncestorBST_235 {
	//递归 
	 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		 /*
		  * 利用BST的性质：left < root < right,判断pq与root的位置关系
		  * */
		 if(root==null || root==q || root==q) return root;
		 int rootVal=root.val;
		 int pVal=p.val;
		 int qVal=q.val;
		 //pq在root两侧  qp在root同侧
		 if(qVal <rootVal && pVal<rootVal) {
			 return lowestCommonAncestor(root.left, p, q);
		 }else if(qVal>rootVal && pVal>rootVal) {
			 return lowestCommonAncestor(root.right, p, q);
		 }else {
			 return root;
		 }
	        
	    }
	 //迭代
	 public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
		 if(root==null || root==q || root==q) return root;
		 TreeNode node=root;
		 int pVal=p.val;
		 int qVal=q.val;
		 while(node!=null) {
			 if(qVal < node.val && pVal < node.val) {
				 node=node.left;
			 }else if(qVal > node.val && pVal > node.val) {
				 node=node.right;
			 }else {//pq在node两侧或者p是pq的最小祖先或者q是pa的最小祖先
				 return node;
			 }
		 }
		 return null;
	 }

}
