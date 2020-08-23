package tree;



public class FlattenBT2LinkedList_114 {
	//N L R -->preorder
	 public void flatten(TreeNode root) {
		 if(root==null) return;
		 TreeNode resRoot=new TreeNode();
		 resRoot=root;
		 helper(root,resRoot.right);
	    }
	 private void helper(TreeNode root,TreeNode resRoot) {
		 if(root==null) return;
		 else {
			 resRoot=root;
			 helper(root.left, resRoot.right);
			 helper(root.right,resRoot.right);
		 }
		 
	 }

}

class Solution_114{
	TreeNode prev=null;
	//TreeNode prev=new TreeNode();
	 public void flatten(TreeNode root) {
		 if(root==null) return;
		 //œ»”“∫Û◊Û 
		 flatten(root.right);
		 flatten(root.left);
		 root.right=prev;
		 root.left=null;
		 prev=root;
	 }
	
}