package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthTree_104 {
    public int maxDepth(TreeNode root) {
    	/**
    	 * 思路：
    	 * 比较每棵树左右两棵子树的深度，大者进行返回
    	 */
        if(root==null) 
        	return 0;
        else {
        	int left_len=maxDepth(root.left)+1;
        	int right_len=maxDepth(root.right)+1;
        	return left_len>right_len?left_len:right_len;
        }
    }
    
    public int maxDepth1(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    /**
     * 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
     * 找出左子树和右子树中高度值比较大的那个，然后在加上根节点的高度，即为整棵树得到高度
     * */
    
    public int bfs(TreeNode root) {
        if(root == null) 
            return 0;
        int max_depth = 0;
        int level_size=-1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
        	level_size=q.size();
        	max_depth++;
        	while(level_size>0) {
        		TreeNode node=q.remove();
        		level_size--;
        		if(node.left!=null) q.add(node.left);
        		if(node.right!=null) q.add(node.right);
        	}
        }
        return max_depth;
        
       
    }

}
