package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView_199 {
	 public List<Integer> rightSideView(TreeNode root) {
		 /*
		  * 思路：利用层序遍历解题*/
		 List<Integer> res=new ArrayList<>();
		 if(root==null) return res;
		 Queue<TreeNode> queue=new LinkedList<>();
		 TreeNode node=null;
		 int size=-1;
		 
		 queue.add(root);
		 while(!queue.isEmpty()) {
			 size=queue.size();
			 while(size>0) {
				 node=queue.poll();
				 if(size==1) {
					 res.add(node.val);
				 }
				 if(node.left!=null) queue.add(node.left);
				 if(node.right!=null) queue.add(node.right);
				 size--;
			 }
			 
		 }
	     return res;
	    }

}

class Soulution_199{
	List<Integer> rightside = new ArrayList<>();
	public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return rightside;
        helper(root, 0);
        return rightside;
    }
	
    public void helper(TreeNode node, int level) {
        if (level == rightside.size())//解题关键
            rightside.add(node.val);
        
        if (node.right != null) 
            helper(node.right, level + 1);  
        if (node.left != null) 
            helper(node.left, level + 1);
    }    
}
