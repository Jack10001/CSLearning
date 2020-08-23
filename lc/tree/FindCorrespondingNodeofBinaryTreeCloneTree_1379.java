package tree;

import java.util.LinkedList;
import java.util.Queue;

public class FindCorrespondingNodeofBinaryTreeCloneTree_1379 {
	 public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
	        //可使用先序或层序遍历 两棵树一起遍历 当原始树遍历到target, 克隆树就遍历到应该返回的结果
		 	//原始树和克隆树的结构一模一样，同时对原始树和克隆树进行遍历
		 if(original==null) return null;
		 if(original==target) return cloned;
		 Queue<TreeNode> originalQueue=new LinkedList<>();
		 Queue<TreeNode> clonedQueue=new LinkedList<>();
		 originalQueue.add(original);
		 clonedQueue.add(cloned);
		 while(!originalQueue.isEmpty()) {
			 
			 TreeNode oNode=originalQueue.remove();
			 TreeNode cNode=clonedQueue.remove();
			 if(oNode==target) return cNode;
			 if(oNode.left!=null) {
				 originalQueue.add(oNode.left);
				 clonedQueue.add(cNode.left);
			 }
			 if(oNode.right!=null) {
				 originalQueue.add(oNode.right);
				 clonedQueue.add(cNode.right);
			 }
		 }
		 return null;
		 
	    }

}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution_1379 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        TreeNode res = null;
        if(original!=null){
            if(original == target) return cloned;
            res = getTargetCopy(original.left, cloned.left, target);
            if(res!=null) return res;
            res = getTargetCopy(original.right, cloned.right, target);
            if(res!=null) return res;
        }
        return res;
    }
}