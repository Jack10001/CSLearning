package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;



public class FlipEquivalentBinaryTrees_951 {
	   public boolean flipEquiv(TreeNode root1, TreeNode root2) {
	       /**
	        * 使用BFS进行遍历,若发现节点的值不相等，则返回root2的某个节点的父节点进行翻转，继续往下进行比较*/
		  
		   if(root1==null && root2==null) 	return true;
		
		   Queue<TreeNode> queue1=new LinkedBlockingDeque<>();
		   Queue<TreeNode> queue2=new LinkedList<>();
		   TreeNode curNode1=null,curNode2=null,parentNode=null;
		   queue1.add(root1);
		   queue2.add(root2);
		   while(!queue1.isEmpty() && !queue2.isEmpty()) {
			   curNode1=queue1.poll();
			   curNode2=queue2.poll();
			   if(curNode1.val==curNode2.val) {
				   parentNode=curNode2;
			   }
			   else {
				   reverse(parentNode);
				   queue2.clear();
				   ((LinkedBlockingDeque<TreeNode>) queue1).addFirst(curNode1);
				   if(parentNode.left!=null) queue2.add(parentNode.left);
				   if(parentNode.right!=null) queue2.add(parentNode.right);
				   continue;
			   }
			   if(curNode1.left!=null) queue1.add(curNode1.left);
			   if(curNode1.right!=null) queue1.add(curNode1.right);
			   
			   if(curNode2.left!=null) queue2.add(curNode2.left);
			   if(curNode2.right!=null) queue2.add(curNode2.right);
			   
		   }
		   return false;
	   }
	   private void reverse(TreeNode node) {
		   if(node==null) return;
		   else {
			   //N
			   TreeNode tmp=node.left;
			   node.right=node.left;
			   node.right=tmp;
			   //L
			   reverse(node.left);
			   //R
			   reverse(node.right);
		   }
	   }

}

class Solution_951 {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {//两个都为空
            return true;
        }
        if ((root1 == null) ^ (root2 == null)) {//其中一个为空
            // if one is null but not the other return false
            return false;
        }
        if (root1.val == root2.val) {//两棵树对应的节点的值相等
            return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))
                || (flipEquiv(root1.right, root2.left) && flipEquiv(root1.left, root2.right));
        }
        return false;
    }
}
