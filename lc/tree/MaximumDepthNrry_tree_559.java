package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthNrry_tree_559 {
	  public int maxDepth(N_node root) {
		  /**
		   * ���������ͳ��N�����ĸ߶�*/
		  if(root==null) return 0;
		  Queue<N_node> queue=new LinkedList<>();
		  queue.add(root);
		  int size=-1;
		  N_node curNode=null;
		  int ans=0;
		  while(!queue.isEmpty()) {
			  size=queue.size();
			  for(int i=0;i<size;i++) {
				  curNode=queue.poll();
				  int child_size=curNode.children.size();
				  for(int j=0;j<child_size;j++) {
					  queue.add(curNode.children.get(j));
					  
				  }
				  
			  }
			  ans++;
		  }
		  	return ans;
	  }
}


class Solution_559 {
	   public int maxDepth(N_node root) {
	        
	        if(root==null) return 0;
	        int max_depth = 0;
	        for(N_node itr:root.children){
	            if(itr!=null) max_depth = Math.max(max_depth, maxDepth(itr));//����������������߶�
	        }
	        return max_depth+1;
	        
	    }
	   //�����������߶�
	   public int maxDepth(TreeNode root) {
			if(root == null){
				return 0;
			}
			
			return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	    }
	}