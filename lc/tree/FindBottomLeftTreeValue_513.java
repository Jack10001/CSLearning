package tree;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue_513 {
	 public int findBottomLeftValue(TreeNode root) {
	     /*
	      * 1.求出树的深度
	      * 2.层序遍历*/ 
		 if(root.left==null && root.right==null) return root.val;
		 int height=getHeight(root);
		 Queue<TreeNode> queue=new LinkedList<>();
		 TreeNode curNode=null;
		 int count=1,size=-1,ans=-1;
		 queue.add(root);
		 while(!queue.isEmpty()) {
			 size=queue.size();
			 //每一层
			 for(int i=0;i<size;i++) {
				 curNode=queue.poll();
				 if(curNode.left!=null) queue.add(curNode.left);
				 if(curNode.right!=null) queue.add(curNode.right);
			 }
			 count++;
			 if(count==height && !queue.isEmpty()) {
				 TreeNode node=queue.poll();
				 ans=node.val;
				 break;
			 }
		 }
		 return ans;
		 
		 
	    }
	 private int getHeight(TreeNode root) {
		 if(root==null) return 0;
		 int left_h=getHeight(root.left)+1;
		 int right_h=getHeight(root.right)+1;
		 return left_h>right_h?left_h:right_h;
	 }

}



class Solution_513 {
    int maxDepth = 0, ans = 0;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return ans;
    }
    public void dfs(TreeNode root, int depth) {
        if(root == null) {
            return;
        }
        //N l R
        //关键是 求树的深度
        if(root.left == null && root.right == null && depth > maxDepth) {
            ans = root.val;
            maxDepth = depth;
        }
        dfs(root.left, depth+1);
        dfs(root.right, depth+1);
        
    }
}
