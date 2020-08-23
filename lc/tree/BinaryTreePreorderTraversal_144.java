package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal_144 {
	//recursive
	 public List<Integer> preorderTraversal(TreeNode root) {
		 List<Integer> res=new ArrayList<>();
		 helper(root,res);
		 return res;
	    }
	 
	 private void helper(TreeNode root,List<Integer> res) {
		 if(root==null) return;
		 else {
			 res.add(root.val);
			 helper(root.left, res);
			 helper(root.right, res);
		 }
	 }
	 
	 //iteratively
	 public List<Integer> preorderTraversal1(TreeNode root) {
		 
	 }

}
