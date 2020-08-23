package tree;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompleteness_of_BinaryTree_958 {
	  //完全二叉树
	 public boolean isCompleteTree(TreeNode root) {
		  if(root==null) return true;
		  if(root.left==null && root.right!=null) return false;
		  Queue<TreeNode> queue=new LinkedList<>();
		  queue.add(root);
		  int size=-1,count=0;
		  TreeNode curNode=null;
		  int depth=depth(root);
          boolean gotNull=false;
		  while(!queue.isEmpty()) {
			  size=queue.size();
			  if(size!=Math.pow(2, count) && count!=depth-1) return false;//fei hua 
			  //最后一层
			  if(count==depth-1) {
				  for(int i=0;i<size;i++) {
					  curNode=queue.poll();
					  if(curNode==null) gotNull=true;
					  if(curNode!=null && gotNull==true) return false;
				  }
			  }
			  for(int i=0;i<size;i++) {
				  curNode=queue.poll();
				  if(curNode.left!=null) queue.add(curNode.left);
				  if(curNode.right!=null) queue.add(curNode.right);
			  }
			  count++;
			  
		  }
		  return true;
	        
	    }
	  private int depth(TreeNode root) {
		  if(root==null) return 0;
		  int left_depth=depth(root.left)+1;
		  int right_depth=depth(root.right)+1;
		  return left_depth>=right_depth?left_depth:right_depth;
	  }

}
class Solution_958{
	 public boolean isCompleteTree(TreeNode root) {
	        if(root == null) return true;
	        Queue<TreeNode> q = new LinkedList<>();
	        q.add(root);
	        boolean gotNull = false;
	        while(!q.isEmpty()){
	            TreeNode temp = q.poll();
	            if(temp == null && gotNull==false){
	                gotNull = true;
	                continue;
	            }
	            if(gotNull==true && temp != null){
	                return false;
	            }
	            if(temp == null) continue;
	            q.add(temp.left);
	            q.add(temp.right);
	            
	        }
	        return true;
	    }
	}