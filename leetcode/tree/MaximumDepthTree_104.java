package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthTree_104 {
    public int maxDepth(TreeNode root) {
    	/**
    	 * ˼·��
    	 * �Ƚ�ÿ��������������������ȣ����߽��з���
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
     * �ҳ����������������и߶�ֵ�Ƚϴ���Ǹ���Ȼ���ڼ��ϸ��ڵ�ĸ߶ȣ���Ϊ�������õ��߶�
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
