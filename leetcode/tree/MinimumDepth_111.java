package tree;

import java.util.LinkedList;
import java.util.Queue;

//BFS
public class MinimumDepth_111 {
	 public int minDepth(TreeNode root) {
		 Queue<TreeNode> queue=new LinkedList<>();
		 int res=0;
		 int size=-1;
		 if(root==null) return 0;
		 queue.add(root);
		 while(!queue.isEmpty()) {
			 size=queue.size();
			 res++;
			 while(size>0) {
				 TreeNode node=queue.poll();
				 size--;
				 if(node.left==null && node.right==null) return res;
				 if(node.left!=null) queue.add(node.left);
				 if(node.right!=null) queue.add(node.right);
			 }
			 
		 }
		return res;
	    }
}


//DFS
class Solution1 {
    public int minDepth(TreeNode root) {   
        // get out quick
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        // recurse right if left is null
        if (root.left == null)
            return minDepth(root.right)+1;
        // recurse left if right is null
        if (root.right == null)
            return minDepth(root.left)+1;
        // return the minimum between each
        return Math.min(minDepth(root.left), 
                        minDepth(root.right)) + 1; 
    }
    
    public int minDepth1(TreeNode root) {
    	if(root==null) return 0;
    	return Math.min(minDepth1(root.left), minDepth1(root.right))+1;
    }
    /**
     * 考虑到左子树或右子树为空的情况，此时树的最小高度并不是0，因此上面的解不合适*/
}
