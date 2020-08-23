package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueinEachTreeRow_515 {
	//BFS
	 public List<Integer> largestValues(TreeNode root) {
		 /*
		  * 1.层序遍历，找到每层的最大值*/
		 List<Integer> ans=new ArrayList<>();
		 if(root==null) return ans;
		 Queue<TreeNode> queue=new LinkedList<>();
		 TreeNode curNode=null;
		 int size=0,max_value;
		 queue.add(root);
		 while(!queue.isEmpty()) {
			 max_value=Integer.MIN_VALUE;
			 size=queue.size();
			 for(int i=0;i<size;i++) {
				 curNode=queue.poll();
				 if(curNode.val>max_value) max_value=curNode.val;
				 if(curNode.left!=null) queue.add(curNode.left);
				 if(curNode.right!=null) queue.add(curNode.right);
			 }
			 ans.add(max_value);
		 }
		 return ans;
	        
	    }

}

class Solution_515 {
    List<Integer> res = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        find(root,0);
        return res;
    }
    
    public void find(TreeNode root, int level){
        if(root == null)
            return;
        
        int max = root.val;
        if(res.size() >= level+1){
            max = Math.max(root.val,res.get(level));
            res.set(level,max);
        }else{
            res.add(level,max);
        }
        
        find(root.left,level+1);
        find(root.right,level+1);
    }
}
