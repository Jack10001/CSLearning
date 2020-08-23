package tree;

public class LowestCommonAncestorBST_235 {
	//�ݹ� 
	 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		 /*
		  * ����BST�����ʣ�left < root < right,�ж�pq��root��λ�ù�ϵ
		  * */
		 if(root==null || root==q || root==q) return root;
		 int rootVal=root.val;
		 int pVal=p.val;
		 int qVal=q.val;
		 //pq��root����  qp��rootͬ��
		 if(qVal <rootVal && pVal<rootVal) {
			 return lowestCommonAncestor(root.left, p, q);
		 }else if(qVal>rootVal && pVal>rootVal) {
			 return lowestCommonAncestor(root.right, p, q);
		 }else {
			 return root;
		 }
	        
	    }
	 //����
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
			 }else {//pq��node�������p��pq����С���Ȼ���q��pa����С����
				 return node;
			 }
		 }
		 return null;
	 }

}
