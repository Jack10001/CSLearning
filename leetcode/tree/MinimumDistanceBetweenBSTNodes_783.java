package tree;


import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;

public class MinimumDistanceBetweenBSTNodes_783 {
	 List<Integer> ans=new ArrayList<>();
	 public int minDiffInBST(TreeNode root) {
		 /*
		  * 中序遍历的过程中做差值比较*/
		 int res=Integer.MAX_VALUE;
		 int temp=-1;
		 inorder(root);
		 for(int i=1;i<ans.size();i++) {
			 temp=(int)Math.abs(ans.get(i)-ans.get(i-1));
			 if(temp<res) {
				 res=temp;
			 }
		 }
	     return res;
	    }
	 private void inorder(TreeNode root) {
		 if(root==null) return;
	     else {
	        	//L N R
	        	minDiffInBST(root.left);
	        	ans.add(root.val);
	        	minDiffInBST(root.right);
	        }
	 }

}


class Solution_783{
	int difference=Integer.MAX_VALUE;
	TreeNode preNode=null; 
	public int minDiffInBST(TreeNode root) {
		 if(root!=null) {
			 //L N R
			 if(root.left!=null) minDiffInBST(root.left);
			 if(preNode!=null) {
				 if((root.val-preNode.val)<difference)
					 difference=root.val-preNode.val;
			 }
			 preNode=root;
			 if(root.right!=null) minDiffInBST(root.right);
		 }
		 return difference;
		 
	 }
	 
	
}