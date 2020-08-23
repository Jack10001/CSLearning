package tree;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceinBST_530 {
	  TreeNode preNode=null;
	  int difference=Integer.MAX_VALUE;
	  public int getMinimumDifference(TreeNode root) {
	        //L N R
		  if(root!=null) {
			  if(root.left!=null)  getMinimumDifference(root.left);//���ķ���ֵ��differentce�������Ƿ��صݹ麯������
			  if(preNode!=null) {
				  if(Math.abs(root.val-preNode.val)<difference)
					  difference=Math.abs(root.val-preNode.val);
			  }
			  preNode=root;
			  
			  if(root.right!=null) getMinimumDifference(root.right);
		  }
		  return difference;
	    }
}


class Solution_530 {
    List<Integer> ans=new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
		 /*
		  * ��������Ĺ���������ֵ�Ƚ�*/
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
	        	inorder(root.left);
	        	ans.add(root.val);
	        	inorder(root.right);
	        }
	 }
}