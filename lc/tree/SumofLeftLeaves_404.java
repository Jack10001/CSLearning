package tree;

import java.util.LinkedList;
import java.util.Queue;


public class SumofLeftLeaves_404 {
	//BFS
	 public int sumOfLeftLeaves(TreeNode root) {
	     if(root==null) return 0;   
		 Queue<TreeNode> queue=new LinkedList<>();
		 int sum=0;
		 TreeNode node=null;
		 queue.add(root);
		 while(!queue.isEmpty()) {
			 node=queue.remove();
			 if(node.left!=null && node.left.left==null && node.left.right==null)
				 sum+=node.left.val;
			 if(node.left!=null)
				 queue.add(node.left);
			 if(node.right!=null)
				 queue.add(node.right);
			 
			 
		 }
		 return sum;
	        
	    }
	 //DFS
	 public int sumOfLeftLeaves1(TreeNode root) {
		    if(root==null)
		        return 0;
		    //∫Û–Ú±È¿˙
		    //L
		    int v1=sumOfLeftLeaves1(root.left);
			//R
		    int v2=sumOfLeftLeaves1(root.right);			
			//N
		    if(root.left!=null && root.left.left==null && root.left.right==null)
				return v1+v2+root.left.val;				
			return v1+v2;
		}
	 
	 
}
