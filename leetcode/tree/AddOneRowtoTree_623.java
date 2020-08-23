package tree;

import java.util.LinkedList;
import java.util.Queue;


public class AddOneRowtoTree_623 {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
    	/*
    	 * BFS*/
    	if(d==1) {
    		TreeNode node=new TreeNode(v);
    		node.left=root;
    		node.right=null;
    		return node;
    	}
    	Queue<TreeNode> queue=new LinkedList<>();
    	TreeNode curNode=null;
    	int curDepth=1,level_size=-1;
    	queue.add(root);
    	while(!queue.isEmpty()) {
    		level_size=queue.size();
    		for(int i=0;i<level_size;i++) {
    			curNode=queue.poll();
    			if(curDepth==(d-1)) {
    				TreeNode left_node=new TreeNode(v);
    				TreeNode right_node=new TreeNode(v);
    				TreeNode left_tmp=curNode.left;
    				TreeNode right_tmp=curNode.right;
    				curNode.left=left_node;
    				curNode.right=right_node;
    				if(left_tmp!=null) left_node.left=left_tmp;
    				if(right_tmp!=null) right_node.right=right_tmp;
    			}
    			if(curNode.left!=null) queue.add(curNode.left);
    			if(curNode.right!=null) queue.add(curNode.right);
    		}
    		curDepth++;
    		if(curDepth==d) break;
    		
    		
    	}
    	
    	

        return root;
    }
}



class Solution_623{
	//DFS depth深度作为递归过程中判断的一个标准
    public TreeNode addOneRow(TreeNode root, int v, int d) {
    	if(d==1) {
    		TreeNode node=new TreeNode(v);
    		node.left=root;
    		node.right=null;
    		return node;
    	}
    	return helper(root,v,d,1);
    	
    }
    
    private TreeNode helper(TreeNode root,int v,int d,int depth) {
    	//N L R
    	if(root==null) return root;
    	if(depth==(d-1)) {
    		TreeNode left_node=new TreeNode(v);
			TreeNode right_node=new TreeNode(v);
			TreeNode left_tmp=root.left;
			TreeNode right_tmp=root.right;
			root.left=left_node;
			root.right=right_node;
			if(left_tmp!=null) left_node.left=left_tmp;
			if(right_tmp!=null) right_node.right=right_tmp;
    		
    	}
    	if(root.left!=null) helper(root.left, v, d, depth+1);
        if(root.right!=null) helper(root.right, v, d, depth+1);
        return root;
    }
    
    
}